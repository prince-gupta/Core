package com.company.lucene;

/**
 * Created by princegupta on 05/11/17.
 */
public class IndexRunner {
    public static void main(String[] args) {
        IndexFiles indexFiles1 = new IndexFiles("Indexer 1");
        IndexFiles indexFiles2 = new IndexFiles("Indexer 2");

        indexFiles1.start();
        indexFiles2.start();

    }
}
