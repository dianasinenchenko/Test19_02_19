package com.example.diana.menutest1;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.github.nitrico.mapviewpager.MapViewPager;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import static android.provider.Settings.Global.getString;
import static com.example.diana.menutest1.R.*;
import static java.security.AccessController.getContext;

/**
 * Created by Diana on 22.04.2018.
 */

public class Sample1Adapter extends MapViewPager.Adapter {



    public static final String[] TITLES = { "Свято-Благовіщенський кафедральний собор", "Собор Успения Пресвятой Богородицы", "Свято-Троицкий Храм", "Озерянская церковь", "Храм иконы Божией Матери" };

    private static String sText = " Собор Благовещения Пресвятой Богородицы, кратко Благовещенский собор в Харькове — самый большой по размерам Кафедральный собор Восточной Европы Харьковско-Богодуховской епархии\n" +
            "        Украинской православной церкви Московского патриархата.\n" +
            "        Первая церковь во имя Благовещения Пресвятой Богородицы основана около 1655 г., одновременно с Николаевской и Рождественской.\n" +
            "        Деревянный однопрестольный храм Залопанского прихода был выполнен в традиционных украинских трёхкупольных формах с отдельно стоящей деревянной рубленной колокольней и обнесён\n" +
            "        плетнём вместо ограды. Бурное развитие поселения дало толчок к расширению прихода: согласно Куряжским актам 1720 г.\n" +
            "        в штате церкви находятся уже двое священников. После крупного пожара в 1738 г. восстановлена в том же виде. Изображение сохранилось на плане города 1787 года.";



    public static final String[] TITLES_test = {  sText ,String.valueOf(string.hram2), String.valueOf(string.hram3),String.valueOf(string.hram4), String.valueOf(string.hram5) };


    public static final CameraPosition[] POSITIONS = {
            CameraPosition.fromLatLngZoom(new LatLng(49.990797, 36.224059), 13f),
            CameraPosition.fromLatLngZoom(new LatLng(49.990086, 36.230754), 17f),
            CameraPosition.fromLatLngZoom(new LatLng(49.986705, 36.232936), 17f),
            CameraPosition.fromLatLngZoom(new LatLng(49.987021, 36.191476), 17f),
            CameraPosition.fromLatLngZoom(new LatLng(50.013467, 36.224973), 17f)
    };


    public Sample1Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }


    public int getCountTest() {
        return TITLES_test.length;
    }

    @Override
    public Fragment getItem(int position) {
        return Sample1Fragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
    public CharSequence getPageTitleTest(int position) {
        return TITLES_test[position];
    }


    @Override
    public CameraPosition getCameraPosition(int position) {
        return POSITIONS[position];
    }

}

