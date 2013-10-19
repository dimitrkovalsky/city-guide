package com.guide.city.dao;

import com.guide.city.entities.Location;
import com.guide.city.entities.PlaceEntity;
import com.guide.city.helpers.DAOFactory;
import org.junit.Test;

public class PlaceDAOTest {

    @Test
    public void testMethod() throws Exception {
        insert();
        update();
        find();
    }

    public void insert() throws Exception {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        PlaceEntity entity = new PlaceEntity(1);
        entity.setName("Винницкий фонтан \"Рошен\"");
        entity.setGeometry(new Location(49.2331, 28.485437));
        entity.setTypes("establishment");
        entity.setFormattedAddress("Винница, Винницкая область, Украина");
        entity.setInformation("Самый большой в Европе плавучий светомузыкальный фонтан открыт в 2011 г. в Виннице на набережной напротив острова Кемпа (Фестивального), рядом с фабрикой \"Рошен\". Винницкий фонтан считается уникальным гидротехническим сооружением. Высота его центральной струи достигает 65-70 м, фронтальный разлет - порядка 140 м, а размеры формируемого брызгами и водяной пылью проекционного экрана - около 16х45 м. Светомузыкальный фонтан \"Рошен\" смонтирован на плавучей платформе длиной 95 м, которая классифицируется как стоечное судно. Танец фигурных струй из 277 форсунок и другие водяные эффекты обеспечивают 67 насосов, которые качают воду прямо из реки Южный Буг. Световые эффекты создают 560 подводных фонарей и лазерные лучи. Ночное шоу воды и света в сопровождении музыки проходит в теплое время года (с конца апреля по конец октября) каждый вечер по трем программам. Днем фонтан работает в режиме статического шоу, вечером - в режиме шоу со световыми эффектами. Период работы фонтана - с 27 апреля по 26 октября.");
        dao.insert(entity);
    }

    public void update() throws Exception {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        PlaceEntity entity = new PlaceEntity(1);
        entity.setName("Винницкий фонтан \"Рошен\"");
        entity.setGeometry(new Location(49.2331, 28.485437));
        entity.setTypes("place_of_worship");
        entity.setFormattedAddress("Винница, Винницкая область, Украина");
        entity.setInformation("Самый большой в Европе плавучий светомузыкальный фонтан открыт в 2011 г. в Виннице на набережной напротив острова Кемпа (Фестивального), рядом с фабрикой \"Рошен\". Винницкий фонтан считается уникальным гидротехническим сооружением. Высота его центральной струи достигает 65-70 м, фронтальный разлет - порядка 140 м, а размеры формируемого брызгами и водяной пылью проекционного экрана - около 16х45 м. Светомузыкальный фонтан \"Рошен\" смонтирован на плавучей платформе длиной 95 м, которая классифицируется как стоечное судно. Танец фигурных струй из 277 форсунок и другие водяные эффекты обеспечивают 67 насосов, которые качают воду прямо из реки Южный Буг. Световые эффекты создают 560 подводных фонарей и лазерные лучи. Ночное шоу воды и света в сопровождении музыки проходит в теплое время года (с конца апреля по конец октября) каждый вечер по трем программам. Днем фонтан работает в режиме статического шоу, вечером - в режиме шоу со световыми эффектами. Период работы фонтана - с 27 апреля по 26 октября.");
        dao.update(entity);
    }

    private void find() throws Exception {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        System.out.println(dao.find(1).toString());
    }
}