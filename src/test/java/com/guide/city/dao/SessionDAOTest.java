package com.guide.city.dao;

import com.guide.city.entities.SessionEntity;
import com.guide.city.helpers.DAOFactory;
import org.bson.types.ObjectId;
import org.junit.Test;


public class SessionDAOTest {
    @Test
    public void testMethod() throws Exception {
//        insert();
//        findByDevice();
    }

    public void insert() throws Exception{
        SessionDAO dao = DAOFactory.getSessionDAO();
        SessionEntity entity = new SessionEntity(new ObjectId());
        entity.setDeviceId("15165165115");
        dao.save(entity);
    }

    private void findByDevice()throws Exception{
        SessionDAO dao = DAOFactory.getSessionDAO();
        System.out.println(dao.findByDeviceId("15165165115"));
    }
}
