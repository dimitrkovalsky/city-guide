package com.guide.city.dao;

import com.guide.city.crawler.GoogleHelper;
import com.guide.city.entities.Location;
import com.guide.city.entities.PlaceEntity;
import com.guide.city.helpers.DAOFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class PlaceDAOTest {

    @Test
    public void testMethod() throws Exception {
        //insert();
        //        update();
        //        find();
        findAll();
    }

    public void insert() throws Exception {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        dao.insert(getEntity());
    }

    public void update() throws Exception {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        PlaceEntity entity = new PlaceEntity(1);
        entity.setName("Винницкий фонтан \"Рошен\"");
        entity.setLocation(new Location(49.2331, 28.485437));
        entity.setTypes(new String[]{"place_of_worship"});
        entity.setFormattedAddress("Винница, Винницкая область, Украина");
        entity.setInformation("Самый большой в Европе плавучий светомузыкальный фонтан открыт в 2011 г. в Виннице на " +
                "набережной напротив острова Кемпа (Фестивального), рядом с фабрикой \"Рошен\". Винницкий фонтан считается " +
                "уникальным гидротехническим сооружением. Высота его центральной струи достигает 65-70 м, фронтальный разлет - порядка 140 м, " +
                "а размеры формируемого брызгами и водяной пылью проекционного экрана - около 16х45 м. Светомузыкальный фонтан \"Рошен\" " +
                "смонтирован на плавучей платформе длиной 95 м, которая классифицируется как стоечное судно. Танец фигурных струй из 277 " +
                "форсунок и другие водяные эффекты обеспечивают 67 насосов, которые качают воду прямо из реки Южный Буг. Световые эффекты создают " +
                "560 подводных фонарей и лазерные лучи. Ночное шоу воды и света в сопровождении музыки проходит в теплое время года (с конца апреля " +
                "по конец октября) каждый вечер по трем программам. Днем фонтан работает в режиме статического шоу, вечером - " +
                "в режиме шоу со световыми эффектами. Период работы фонтана - с 27 апреля по 26 октября.");
        dao.update(entity);
    }

    private void find() throws Exception {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        System.out.println(dao.find(1).toString());
    }

    private void findAll() throws Exception {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        List<PlaceEntity> places = dao.findAll();
        System.out.println(places.toString());
    }

    public PlaceEntity getEntity() throws IOException, JSONException {
        JSONObject response = GoogleHelper
                .read("https://maps.googleapis.com/maps/api/place/textsearch/json?sensor=false&query=%D0%A6%D0%B5%D1%80%D0%BA%D0%BE%D0%B2%D1%8C+%D0%95%D0%A5%D0%91+%22%D0%94%D0%BE%D0%BC+%D0%95%D0%B2%D0%B0%D0%BD%D0%B3%D0%B5%D0%BB%D0%B8%D1%8F%22%2C+%D1%83%D0%BB%D0%B8%D1%86%D0%B0+%D0%9C%D0%B0%D0%BA%D1%81%D0%B8%D0%BC%D0%BE%D0%B2%D0%B8%D1%87%D0%B0%2C+%D0%92%D0%B8%D0%BD%D0%BD%D0%B8%D1%86%D0%B0%2C+%D0%92%D0%B8%D0%BD%D0%BD%D0%B8%D1%86%D0%BA%D0%B0%D1%8F+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C&key=AIzaSyCd5bBuiljMgprbV2NbHZwVT4V-A2_nKE8");
        JSONObject location = response.getJSONArray("results").getJSONObject(0);
        PlaceEntity entity = new PlaceEntity(13);
        entity.setName(location.getString("name"));
        entity.setLocation(new Location(49.235831, 28.42604));
        entity.setTypes(new String[]{"church", "place_of_worship", "establishment"});
        entity.setFormattedAddress(location.getString("formatted_address"));
        entity.setInformation(
                "Баптистская церковь в городе Виннице была основана в 1917 году. Первое служение состоялось 7 апреля 1917 г. в помещении государственного банка (сейчас 19-я школа), которое проводил брат Франс Жадкевич, будущий пресвитер Винницкой баптистской церкви. В конце 80-х годов здание уже не вмещало всех желающих и было решено строить новое здание по улице Максимовича. Строительство новой церкви началось в 1990 году и официальное открытие состоялось 21 июля 1996 г. Среди пяти баптистских церквей города, церковь \"Дом Евангелия\" сейчас самая большая - 1500 членов церкви.");
        entity.setImageUrl(new String[]{"http://static.panoramio.com/photos/large/66750585.jpg"});
        return entity;
    }
}