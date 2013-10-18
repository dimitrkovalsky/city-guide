package com.guide.city.dao;


import com.guide.city.entities.GeolocationEntity;
import com.guide.city.entities.Location;
import com.guide.city.entities.SessionEntity;
import com.guide.city.helpers.DAOFactory;
import org.bson.types.ObjectId;
import org.junit.Test;

public class GeolocationDAOTest {
    @Test
    public void testMethod() throws Exception {
        insert();
        //findByDevice();
        findNear();
    }

    public void insert() throws Exception {
        GeolocationDAO dao = DAOFactory.getGeolocationDAO();
        GeolocationEntity entity = new GeolocationEntity();
        entity.setDeviceId("100500");
        entity.setAccuracy(100f);
        entity.setLocation(new Location(105.4d, 104.8d));
        entity.setTimestamp(System.currentTimeMillis());
        dao.save(entity);
    }

    private void findByDevice() throws Exception {
        GeolocationDAO dao = DAOFactory.getGeolocationDAO();
        System.out.println(dao.findByDeviceId("15165165115"));
    }

    private void findNear() throws Exception {
        GeolocationDAO dao = DAOFactory.getGeolocationDAO();
        System.out.println(dao.findNear(new Location(105d, 105d), 10));
    }

}