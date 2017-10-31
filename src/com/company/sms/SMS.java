package com.company.sms;


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.prefs.Preferences;


/**
 * This class manages connection to Way2sms.
 * - Supports sending messages to groups.
 * - Importing online contacts.
 *
 * @author Shailesh K Soliwal
 */
public class SMS {

    private static final String ERROR_IMPORTING_CONTACTS = "Failed to get online contacts...";

    private static final String LOGIN_SUCCESSFUL = "Login Successful...";

    private static final String LOGIN_FAILED = "Login Failed...";

    private static final String INPUT_VALIDATION_FAILED = "Failure: Input Validation Failed.";

    private static final String FAILURE_SMS_SENT = "Failure: SMS Sent Failed.";

    private static final String CONNECTION_FAILURE = "Failure: Failed to connect to way2sms.com, Check your internet connection/proxy.";

    private static final String SUCCESS = "Message has been submitted successfully";

    private URL url = null;

    private HttpURLConnection connection = null;

    private static String CUST_FROM = null;

    private Preferences prefs = null;

    /**
     * Send messages using way2sms.com.
     *
     * @param uid the Login id, users phone number.
     * @param pwd the Login Password.
     * @param phone Phone numbers to send messages to.
     * @param msg the message to be sent.
     * @param proxy to enable proxy if required (proxyIP:proxyPort)
     */
    public void send(String uid, String pwd, String phone, String msg, String proxy) {
        try {
            prefs = Preferences.userNodeForPackage(SMS.class);
            CUST_FROM = prefs.get("custFrom", null);

            uid = validateUserId(uid);
            pwd = validatePassword(pwd);
            msg = validatePhoneNumberAndMessage(phone, msg);
            Vector<Long> numbers = new Vector<Long>();
            parseNumbers(phone, numbers);
            setupProxy(proxy);

            // Login
            String cookie = login(uid, pwd);
            if (cookie != null && cookie.trim().length() > 0) {
                // Send SMS
                sendMessages(msg, numbers, cookie);
                // Logout
                logout(cookie);
            }
        } catch (UnknownHostException e1) {
            log(CONNECTION_FAILURE);
            e1.printStackTrace();
        } catch (IOException e1) {
            log(FAILURE_SMS_SENT);
            e1.printStackTrace();
        } catch (IllegalArgumentException e1) {
            log(INPUT_VALIDATION_FAILED);
            e1.printStackTrace();
        }
    }

    /**
     * Login to way2sms.com
     *
     * @param uid the Login id, users phone number.
     * @param pwd the Login Password.
     *
     * @return the cookie
     *
     * @throws java.net.MalformedURLException the malformed url exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws java.net.ProtocolException the protocol exception
     */
    private String login(String uid, String pwd) {
        log("Logging in ...");
        String cookie = "";
        try {
            String loginString = "username=" + uid + "&password=" + pwd  + "&Submit=Sign+in";
            PrintWriter pw1 = null;
            (connection = (HttpURLConnection)(url = new URL("http://site24.way2sms.com//auth.cl")).openConnection()).setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Host", "site24.way2sms.com");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729) FBSMTWB");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            connection.setRequestProperty("Accept-Language", "en-US,ja-JP;q=0.5");
            connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            connection.setRequestProperty("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
            connection.setRequestProperty("keep-alive", "300 ");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Referer", "http://site24.way2sms.com//entry.jsp");
            connection.setRequestProperty("Cookie", cookie);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(loginString.length()));
            connection.setRequestMethod("POST");
            connection.setInstanceFollowRedirects(false);
            (pw1 = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()), true)).print(loginString);
            pw1.flush();
            pw1.close();

            new BufferedReader(new InputStreamReader(connection.getInputStream()));
            cookie = connection.getHeaderField("Set-Cookie");
            System.out.println(cookie);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int httpResponseCode = connection.getResponseCode();

            StringBuffer msgResponse = new StringBuffer(10000);
            if (httpResponseCode == 200 || httpResponseCode == 302) {
                String s2 = br.readLine();

                while (s2 != null) {
                    msgResponse.append(s2);
                    s2 = br.readLine();
                }
            }

            cookie = connection.getHeaderField("Set-Cookie");
            if(cookie != null && cookie.length() > 0) {
                log(LOGIN_SUCCESSFUL);
            } else {
                log(LOGIN_FAILED);
            }

        } catch (UnknownHostException e1) {
            log(LOGIN_SUCCESSFUL);
            log(CONNECTION_FAILURE);
            e1.printStackTrace();
        } catch (IOException e1) {
            log(LOGIN_FAILED);
            e1.printStackTrace();
        }
        return cookie;
    }

    /**
     * Send messages.
     *
     * @param msg the message to be sent.
     * @param phone Phone numbers to send messages to.
     * @param cookie the cookie
     *
     * @throws java.net.MalformedURLException the malformed url exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws java.net.ProtocolException the protocol exception
     */
    private void sendMessages(String msg, Vector<Long> numbers, String cookie) throws MalformedURLException, IOException, ProtocolException {
        String content = "";
        PrintWriter pw = null;
        BufferedReader br = null;
        url = null;
        connection = null;
        int i = 0;
        Iterator<Long> numIter = numbers.iterator();
        log("Number of messages to be sent = " + numbers.size());

        while (numIter.hasNext()) {
            Long num = (Long) numIter.next();
            i++;
            log("(" + i + " out of " + numbers.size() +") Sending message to : " + num);

            int loopToGetCustFrom = 1;
            if(CUST_FROM == null || CUST_FROM.length() == 0) {
                loopToGetCustFrom = 100;
            }

            for(int j = 1; j <= loopToGetCustFrom; j++) {
                if(CUST_FROM == null || CUST_FROM.length() <= 0 ) {
                    content = "custid=undefined&HiddenAction=instantsms&Action=custfrom"+ (j*50000) +
                            "&login=&pass=&MobNo=" + num + "&textArea=" + msg +
                            "&qlogin1=Gmail+Id&qpass1=******&gincheck=on&ylogin1=Yahoo+Id&ypass1=******&yincheck=on";
                } else {
                    content = "custid=undefined&HiddenAction=instantsms&Action=custfrom"+CUST_FROM +
                            "&login=&pass=&MobNo=" + num + "&textArea=" + msg +
                            "&qlogin1=Gmail+Id&qpass1=******&gincheck=on&ylogin1=Yahoo+Id&ypass1=******&yincheck=on";
                }

                url = new URL("http://wwwd.way2sms.com/FirstServletsms?custid=");
                connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.0.5) Gecko/2008120122 Firefox/3.0.5");
                connection.setRequestProperty("Content-Length", String.valueOf(content.length()));
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Accept", "*/*");
                connection.setRequestProperty("Referer", "http://site24.way2sms.com//jsp/InstantSMS.jsp?val=0");
                connection.setRequestProperty("Cookie", cookie);
                connection.setRequestMethod("POST");
                connection.setInstanceFollowRedirects(false);
                pw = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()), true);
                pw.print(content);
                pw.flush();
                pw.close();

                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String httpResponse = br.readLine();

                int httpResponseCode = connection.getResponseCode();
                if (httpResponseCode == 200 || httpResponseCode == 302) {
                    StringBuffer msgResponse = new StringBuffer(10000);
                    while (httpResponse != null) {
                        httpResponse = br.readLine();
                        msgResponse.append(httpResponse);
                    }

                    //System.out.println(msgResponse.toString());

                    if (msgResponse.indexOf(SUCCESS) >= 0) {
                        log(SUCCESS);
                        if(CUST_FROM == null || CUST_FROM.length() <= 0) {
                            CUST_FROM = String.valueOf(j*50000);
                            prefs.put("custFrom", CUST_FROM);
                            j = loopToGetCustFrom+1;	// Break out of the loop
                        }
                    } else {
                        if(CUST_FROM == null || CUST_FROM.length() <= 0) {
                            //dont throw error
                        } else {
                            if (msgResponse.indexOf("Not A Valid") >= 0) {
                                log(FAILURE_SMS_SENT +", Invalid mobile Number...");
                            } else {
                                log(FAILURE_SMS_SENT);
                            }
                        }
                    }
                } else {
                    if(CUST_FROM == null || CUST_FROM.length() <= 0) {
                        //dont throw error
                    } else {
                        log(FAILURE_SMS_SENT);
                    }
                }
                br.close();
                url = null;
                connection = null;

            }
        }
    }

    /**
     * Logout.
     *
     * @param cookie the cookie
     *
     * @throws MalformedURLException the malformed url exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ProtocolException the protocol exception
     */
    private void logout(String cookie) throws MalformedURLException, IOException, ProtocolException {
        url = new URL("http://wwwd.way2sms.com/jsp/logout.jsp");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Cookie", cookie);
        connection.setRequestMethod("GET");
        connection.setInstanceFollowRedirects(false);
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while (br.readLine() != null) {
        }
        br.close();
        int httpResponseCode = connection.getResponseCode();

        if (httpResponseCode == 200 || httpResponseCode == 302) {
            log("Logout successfull ...");
        } else {
            log("Logout Failed ...");
        }

        url = null;
        connection = null;
    }

    /**
     * Import online contacts.
     *
     * @param uid the Login id, users phone number.
     * @param pwd the Login Password.
     * @param proxy to enable proxy if required (proxyIP:proxyPort)
     *
     * @return the contacts
     */
    public ArrayList<Contact> importOnlineContacts(String uid, String pwd, String proxy) {
        ArrayList<Contact> contacts = null;
        try {
            uid = validateUserId(uid);
            pwd = validatePassword(pwd);
            setupProxy(proxy);
            String cookie = login(uid, pwd);
            String quickContactsResponse = getContacts(cookie);
            contacts = parseOnlineContacts(quickContactsResponse);
        } catch (Exception e1) {
            log("Failed to connect to way2sms.com");
            e1.printStackTrace();
        }
        return contacts;
    }

    private String getContacts(String cookie) {
        PrintWriter pw1 = null;
        String quickContactsResponse = "";
        try {
            if (cookie != null) {
                url = new URL("http://site24.way2sms.com//QuickContacts");
                String loginString = "folder=DashBoard";
                (connection = (HttpURLConnection) url.openConnection()).setDoOutput(true);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                connection.setRequestProperty("Content-Length", String.valueOf(loginString.length()));
                connection.setRequestProperty("Cookie", cookie);
                connection.setRequestMethod("POST");
                connection.setInstanceFollowRedirects(false);
                (pw1 = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()), true)).print(loginString);
                pw1.flush();
                pw1.close();

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                int httpResponseCode = connection.getResponseCode();

                if (httpResponseCode == 200 || httpResponseCode == 302) {
                    String s2 = br.readLine();
                    StringBuffer msgResponse = new StringBuffer(10000);
                    while (s2 != null) {
                        msgResponse.append(s2);
                        s2 = br.readLine();
                    }
                    quickContactsResponse = msgResponse.toString();

                    if (msgResponse.length() <= 1) {
                        log(ERROR_IMPORTING_CONTACTS);
                    } else
                        log("Import Sucessfull...");
                } else {
                    log(ERROR_IMPORTING_CONTACTS);
                }
            } else {
                log(ERROR_IMPORTING_CONTACTS);
            }

        } catch (UnknownHostException e1) {
            log(ERROR_IMPORTING_CONTACTS);
            log("Failed to connect to way2sms.com");
            e1.printStackTrace();
        } catch (IOException e1) {
            log(ERROR_IMPORTING_CONTACTS);
            e1.printStackTrace();
        }
        return quickContactsResponse;
    }

    /**
     * Parses the online contacts html response.
     *
     * @param quickContactsResponse the quick contacts response
     *
     * @return the online contacts
     */
    private ArrayList<Contact> parseOnlineContacts(String quickContactsResponse) {
        String prefix = "seleContacts1(";
        String csv = quickContactsResponse.substring(quickContactsResponse.indexOf(prefix) + prefix.length(), quickContactsResponse.indexOf(")\">"));
        csv = csv.replaceAll("['\\ ]", "");
        csv = csv.replaceAll(",,", ",");
        String[] csvValues = csv.split(",");
        ArrayList<Contact> contactList = new ArrayList<Contact>();

        if (csvValues.length > 0) {
            int noOfContacts = Integer.parseInt(csvValues[0]);
            Contact contact = null;
            for (int i = 0; i < noOfContacts; i++) {
                contact = new Contact(false, csvValues[i + 1], csvValues[i + 1 + noOfContacts], "");
                contactList.add(contact);
            }
        }
        return contactList;
    }

    /**
     * Setup proxy.
     *
     * @param proxy the proxy
     */
    private static void setupProxy(String proxy) {
        // Proxy
        if (proxy.length() > 0) {
            String host = "";
            String port = "";
            int colonIndex = proxy.indexOf(':');

            if (colonIndex > 0) {
                host = proxy.substring(0, colonIndex);
                port = proxy.substring(colonIndex + 1, proxy.length());
            } else {
                host = proxy;
                port = "80";
            }
            System.getProperties().put("proxySet", "true");
            System.getProperties().put("proxyHost", host);
            System.getProperties().put("proxyPort", port);
            log("Proxy Enabled : " + host + " : " + port);
        } else {
            System.getProperties().put("proxySet", "false");
            System.getProperties().remove("proxyHost");
            System.getProperties().remove("proxyPort");
        }
    }

    /**
     * Parses the numbers.
     *
     * @param phone the phone
     * @param numbers the numbers
     */
    private static void parseNumbers(String phone, Vector<Long> numbers) {
        String pharr[];
        if (phone.indexOf(',') >= 0) {
            pharr = phone.split(",");
            for (String t : pharr) {
                try {
                    numbers.add(Long.valueOf(t));
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Give proper phone numbers.");
                }
            }
        } else {
            try {
                numbers.add(Long.valueOf(phone));
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Give proper phone numbers.");
            }
        }

        if (0 == numbers.size())
            throw new IllegalArgumentException("At least one proper phone number should be present to send SMS.");
    }

    /**
     * Validate phone number and message.
     *
     * @param phone the phone
     * @param msg the msg
     *
     * @return the string
     *
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    private static String validatePhoneNumberAndMessage(String phone, String msg) throws UnsupportedEncodingException {
        if (phone == null || 0 == phone.length())
            throw new IllegalArgumentException("At least one phone number should be present.");

        if (msg == null || 0 == msg.length())
            throw new IllegalArgumentException("SMS message should be present.");
        else
            msg = URLEncoder.encode(msg, "UTF-8");
        return msg;
    }

    /**
     * Validate password.
     *
     * @param pwd the pwd
     *
     * @return the string
     *
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    private static String validatePassword(String pwd) throws UnsupportedEncodingException {
        if (pwd == null || 0 == pwd.length())
            throw new IllegalArgumentException("Password should be present.");
        else
            pwd = URLEncoder.encode(pwd, "UTF-8");
        return pwd;
    }

    /**
     * Validate user id.
     *
     * @param uid the uid
     *
     * @return the string
     *
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    private static String validateUserId(String uid) throws UnsupportedEncodingException {
        if (uid == null || 0 == uid.length())
            throw new IllegalArgumentException("User ID should be present.");
        else
            uid = URLEncoder.encode(uid, "UTF-8");
        return uid;
    }

    /**
     * Logging.
     *
     * @param logInfo the log info
     */
    static void log(String logInfo) {
        System.out.println(logInfo);
    }
}
