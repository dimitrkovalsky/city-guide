package com.guide.city.helpers;


import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.guide.city.dao.AccountDAO;
import com.guide.city.dao.GeolocationDAO;
import com.guide.city.dao.PlaceDAO;
import com.guide.city.dao.SessionDAO;
import com.mongodb.Mongo;

import java.net.UnknownHostException;

public class DAOFactory {
    private static String DATABASE_URL = "127.0.0.1";
    private static int DATABASE_PORT = 27017;
    private static String DATABASE_NAME = "guidedb";
    private static Datastore datastore;

    static {
        try {

            Mongo mongo = new Mongo(DATABASE_URL, DATABASE_PORT);
            Morphia morphia = new Morphia();
            datastore = morphia.createDatastore(mongo, DATABASE_NAME);
        }
        catch (UnknownHostException e) {
            System.err.println("Error ");
        }
    }

    public static SessionDAO getSessionDAO() {
        return new SessionDAO(datastore);
    }

    public static AccountDAO getAccountDAO() {
        return new AccountDAO(datastore);
    }

    public static GeolocationDAO getGeolocationDAO() {
        return new GeolocationDAO(datastore);
    }

    public static PlaceDAO getPlaceDAO(){
        return new PlaceDAO(datastore);
    }
}
