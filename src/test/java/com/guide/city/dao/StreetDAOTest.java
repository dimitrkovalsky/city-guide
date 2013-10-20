package com.guide.city.dao;

import com.guide.city.entities.Location;
import com.guide.city.entities.StreetEntity;
import com.guide.city.exceptions.DAOException;
import com.guide.city.helpers.DAOFactory;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * User: mkontarev
 * Date: 10/19/13
 * Time: 8:01 PM
 */
public class StreetDAOTest {

    @Test
    public void testMethod() throws Exception {
        //  insert();
        findByName();
        //        update();
        //        find();
        //        findAll();
    }

    public void insert() throws Exception {
        StreetDAO dao = DAOFactory.getStreetDAO();
        dao.insert(getEntity());
    }

    public void update() throws Exception {
        //        StreetDAO dao = DAOFactory.getStreetDAO();
        //        StreetEntity entity = new StreetEntity(1);
        //        entity.setName("Винницкий фонтан \"Рошен\"");
        //        entity.setFormattedAddress("Винница, Винницкая область, Украина");
        //        entity.setInformation("Самый большой в Европе плавучий светомузыкальный фонтан открыт в 2011 г. в Виннице на " +
        //                "набережной напротив острова Кемпа (Фестивального), рядом с фабрикой \"Рошен\". Винницкий фонтан считается " +
        //                "уникальным гидротехническим сооружением. Высота его центральной струи достигает 65-70 м, фронтальный разлет - порядка 140 м, " +
        //                "а размеры формируемого брызгами и водяной пылью проекционного экрана - около 16х45 м. Светомузыкальный фонтан \"Рошен\" " +
        //                "смонтирован на плавучей платформе длиной 95 м, которая классифицируется как стоечное судно. Танец фигурных струй из 277 " +
        //                "форсунок и другие водяные эффекты обеспечивают 67 насосов, которые качают воду прямо из реки Южный Буг. Световые эффекты создают " +
        //                "560 подводных фонарей и лазерные лучи. Ночное шоу воды и света в сопровождении музыки проходит в теплое время года (с конца апреля " +
        //                "по конец октября) каждый вечер по трем программам. Днем фонтан работает в режиме статического шоу, вечером - " +
        //                "в режиме шоу со световыми эффектами. Период работы фонтана - с 27 апреля по 26 октября.");
        //        dao.update(entity);
    }

    private void find() throws Exception {
        StreetDAO dao = DAOFactory.getStreetDAO();
        System.out.println(dao.find(1).toString());
    }

    public void findByName() throws DAOException {
        StreetDAO dao = DAOFactory.getStreetDAO();
        StreetEntity streetEntity = dao.findNear(new Location(49.237319, 28.487782));
        System.out.println(streetEntity);
    }

    private void findAll() throws Exception {
        StreetDAO dao = DAOFactory.getStreetDAO();
        List<StreetEntity> streets = dao.findAll();
        System.out.println(streets.toString());
    }

    public StreetEntity getEntity() throws IOException, JSONException {
        StreetEntity entity = new StreetEntity(2);
        entity.setName("Vasylya Poryka street");
        entity.setFormattedAddress("Vasylya Poryka street, Vinnytsia, Vinnyts'ka oblast, Ukraine");
        entity.setInformation(
                "Vasily Vasilyevich Porik (on February 17, 1920 — on July 22, 1944) — the Hero of the Soviet Union, the National Hero of France, the lieutenant, the organizer and the commander of guerrilla group in Northern France.");

        return entity;
    }
}
