package edu.au.cpsc.module4.data;

import java.io.*;

public class AirlineDatabaseIO {

    public static void save(AirlineDatabase ad, OutputStream strm) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(strm);
        out.writeObject(ad);
    }
    public static AirlineDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(strm);
        return (AirlineDatabase) in.readObject();
    }
}