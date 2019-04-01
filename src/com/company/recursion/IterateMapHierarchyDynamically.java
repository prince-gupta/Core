package com.company.recursion;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IterateMapHierarchyDynamically {

    /*
    {
   "txnno":"00045265A06F7AD4",
   "txndate":"14/03/2018 00:00:00",
   "txnGMTdate":"14/03/2018 00:00:00",
   "txntypeid":"1",
   "currency":{
      "lc":"AED",
      "fc":"INR"
   },
   "sender":{
      "senderid":"0",
      "senderdescription":"",
      "agentcode":"UAEEXAEHQ001",
      "customerno":"0029778415463535",
      "cashierid":"dhanyan"
   },
   "receiver":{
      "receiverid":"0",
      "receiverdescription":"",
      "agentcodeto":"",
      "cashiercodeto":""
   },
   "charges":{
      "txnamount.lc":"1000.000",
      "othercharge.lc":"1000.000",
      "margin.lc":"1000.000",
      "commission.lc":"1000.000",
      "tax.lc":"1000.000",
      "cardcharge.lc ":"1000.000",
      "additionalcharge.lc":"1000.000",
      "roundoff.lc":"1000.000",
      "txnamount.fc":"1000.000",
      "othercharge.fc":"1000.000",
      "margin.fc":"1000.000",
      "commission.fc":"1000.000",
      "tax.fc":"1000.000",
      "cardcharge.fc ":"1000.000",
      "additionalcharge.fc":"1000.000",
      "roundoff.fc":"1000.000",
      "txnamount.usd":"1000.000",
      "othercharge.usd":"1000.000",
      "margin.usd":"1000.000",
      "commission.usd":"1000.000",
      "tax.usd":"1000.000",
      "cardcharge.usd ":"1000.000",
      "additionalcharge.usd":"1000.000",
      "roundoff.usd":"1000.000",
      "cstotalamt":"1000.000",
      "cqtotalamt":"1000.000",
      "cctotalamt":"1000.000",
      "dctotalamt":"1000.000",
      "actotalamt":"1000.000",
      "optotalamt":"1000.000",
      "kntotalamt":"1000.000",
      "dftotalamt":"1000.000",
      "wltotalamt":"1000.000"
   },
   "convrates":{
      "lc2fc":"0.12345678",
      "usd2lc":"0.12345678",
      "usd2fc":"0.12345678"
   },
   "othertxnInfo":{
      "cheque":[
         {
            "chequeno":"964",
            "chequedate":"14/03/2018 00:00:00",
            "bankname":"ARAB BANK",
            "partyname":"ALWEJDAN FOR TRAVEL AND TOURS",
            "chequeamount":"8000000"
         },
         {
            "chequeno":"965",
            "chequedate":"14/03/2018 00:00:00",
            "bankname":"ARAB BANK",
            "partyname":"ALWEJDAN FOR TRAVEL AND TOURS",
            "chequeamount":"8000000"
         }
      ],
      "customerstatus":"2",
      "customertype":"1048576",
      "customerfirstname":"John"
   }
}
     */
    private Object iterate(Object input, String key) {
        if (input == null || key == null || key.equals("")) {
            throw new IllegalArgumentException();
        }
        if (input instanceof Map) {
            Map tempMap = (LinkedHashMap) input;
            if (tempMap.size() == 0) {
                throw new IllegalArgumentException("");
            }
            Set<Map.Entry> entrySet = tempMap.entrySet();
            for (Map.Entry entry : entrySet) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                } else {
                    if (entry.getValue() instanceof Map) {
                        Object value = iterate(entry.getValue(), key);
                        if (value != null) {
                            return value;
                        }
                    } else if (entry.getValue() instanceof List) {
                        for (Object listObj : (List) entry.getValue()) {
                            Object value = iterate(listObj, key);
                            if (value != null) {
                                return value;
                            }
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return null;
    }
}
