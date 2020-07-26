package com.codeforce.product.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*Alimbetov Ruslan*/
public class Form_UI {

    public static List<WeigthDescription> getWlist() {
        List<WeigthDescription> result = new ArrayList<>();
        for (double i = 1; i < 101; i++) {
            result.add(new WeigthDescription(i, i + " kg"));
        }
        return result;
    }

    public static List<String> getCountryList() {
        List<String> result = new ArrayList<>();
        result.add("Абхазия[ABH]");
        result.add("Австралия[AUS]");
        result.add("Австрия[AUT]");
        result.add("Азербайджан[AZE]");
        result.add("Албания[ALB]");
        result.add("Алжир[DZA]");
        result.add("Американское Самоа[ASM]");
        result.add("Ангилья[AIA]");
        result.add("Ангола[AGO]");
        result.add("Андорра[AND]");
        result.add("Антарктида[ATA]");
        result.add("Антигуа и Барбуда[ATG]");
        result.add("Аргентина[ARG]");
        result.add("Армения[ARM]");
        result.add("Аруба[ABW]");
        result.add("Афганистан[AFG]");
        result.add("Багамы[BHS]");
        result.add("Бангладеш[BGD]");
        result.add("Барбадос[BRB]");
        result.add("Бахрейн[BHR]");
        result.add("Беларусь[BLR]");
        result.add("Белиз[BLZ]");
        result.add("Бельгия[BEL]");
        result.add("Бенин[BEN]");
        result.add("Бермуды[BMU]");
        result.add("Болгария[BGR]");
        result.add("Боливия, Многонациональное Государство[BOL]");
        result.add("Бонайре, Саба и Синт-Эстатиус[BES]");
        result.add("Босния и Герцеговина[BIH]");
        result.add("Ботсвана[BWA]");
        result.add("Бразилия[BRA]");
        result.add("Британская территория в Индийском океане[IOT]");
        result.add("Бруней-Даруссалам[BRN]");
        result.add("Буркина-Фасо[BFA]");
        result.add("Бурунди[BDI]");
        result.add("Бутан[BTN]");
        result.add("Вануату[VUT]");
        result.add("Венгрия[HUN]");
        result.add("Венесуэла Боливарианская Республика[VEN]");
        result.add("Виргинские острова, Британские[VGB]");
        result.add("Виргинские острова, США[VIR]");
        result.add("Вьетнам[VNM]");
        result.add("Габон[GAB]");
        result.add("Гаити[HTI]");
        result.add("Гайана[GUY]");
        result.add("Гамбия[GMB]");
        result.add("Гана[GHA]");
        result.add("Гваделупа[GLP]");
        result.add("Гватемала[GTM]");
        result.add("Гвинея[GIN]");
        result.add("Гвинея-Бисау[GNB]");
        result.add("Германия[DEU]");
        result.add("Гернси[GGY]");
        result.add("Гибралтар[GIB]");
        result.add("Гондурас[HND]");
        result.add("Гонконг[HKG]");
        result.add("Гренада[GRD]");
        result.add("Гренландия[GRL]");
        result.add("Греция[GRC]");
        result.add("Грузия[GEO]");
        result.add("Гуам[GUM]");
        result.add("Дания[DNK]");
        result.add("Джерси[JEY]");
        result.add("Джибути[DJI]");
        result.add("Доминика[DMA]");
        result.add("Доминиканская Республика[DOM]");
        result.add("Египет[EGY]");
        result.add("Замбия[ZMB]");
        result.add("Западная Сахара[ESH]");
        result.add("Зимбабве[ZWE]");
        result.add("Израиль[ISR]");
        result.add("Индия[IND]");
        result.add("Индонезия[IDN]");
        result.add("Иордания[JOR]");
        result.add("Ирак[IRQ]");
        result.add("Иран, Исламская Республика[IRN]");
        result.add("Ирландия[IRL]");
        result.add("Исландия[ISL]");
        result.add("Испания[ESP]");
        result.add("Италия[ITA]");
        result.add("Йемен[YEM]");
        result.add("Кабо-Верде[CPV]");
        result.add("Казахстан[KAZ]");
        result.add("Камбоджа[KHM]");
        result.add("Камерун[CMR]");
        result.add("Канада[CAN]");
        result.add("Катар[QAT]");
        result.add("Кения[KEN]");
        result.add("Кипр[CYP]");
        result.add("Киргизия[KGZ]");
        result.add("Кирибати[KIR]");
        result.add("Китай[CHN]");
        result.add("Кокосовые (Килинг) острова[CCK]");
        result.add("Колумбия[COL]");
        result.add("Коморы[COM]");
        result.add("Конго[COG]");
        result.add("Конго, Демократическая Республика[COD]");
        result.add("Корея, Народно-Демократическая Республика[PRK]");
        result.add("Корея, Республика[KOR]");
        result.add("Коста-Рика[CRI]");
        result.add("Кот д'Ивуар[CIV]");
        result.add("Куба[CUB]");
        result.add("Кувейт[KWT]");
        result.add("Кюрасао[CUW]");
        result.add("Лаос[LAO]");
        result.add("Латвия[LVA]");
        result.add("Лесото[LSO]");
        result.add("Ливан[LBN]");
        result.add("Ливийская Арабская Джамахирия[LBY]");
        result.add("Либерия[LBR]");
        result.add("Лихтенштейн[LIE]");
        result.add("Литва[LTU]");
        result.add("Люксембург[LUX]");
        result.add("Маврикий[MUS]");
        result.add("Мавритания[MRT]");
        result.add("Мадагаскар[MDG]");
        result.add("Майотта[MYT]");
        result.add("Макао[MAC]");
        result.add("Малави[MWI]");
        result.add("Малайзия[MYS]");
        result.add("Мали[MLI]");
        result.add("Малые Тихоокеанские отдаленные острова Соединенных Штатов[UMI]");
        result.add("Мальдивы[MDV]");
        result.add("Мальта[MLT]");
        result.add("Марокко[MAR]");
        result.add("Мартиника[MTQ]");
        result.add("Маршалловы острова[MHL]");
        result.add("Мексика[MEX]");
        result.add("Микронезия, Федеративные Штаты[FSM]");
        result.add("Мозамбик[MOZ]");
        result.add("Молдова, Республика[MDA]");
        result.add("Монако[MCO]");
        result.add("Монголия[MNG]");
        result.add("Монтсеррат[MSR]");
        result.add("Мьянма[MMR]");
        result.add("Намибия[NAM]");
        result.add("Науру[NRU]");
        result.add("Непал[NPL]");
        result.add("Нигер[NER]");
        result.add("Нигерия[NGA]");
        result.add("Нидерланды[NLD]");
        result.add("Никарагуа[NIC]");
        result.add("Ниуэ[NIU]");
        result.add("Новая Зеландия[NZL]");
        result.add("Новая Каледония[NCL]");
        result.add("Норвегия[NOR]");
        result.add("Объединенные Арабские Эмираты[ARE]");
        result.add("Оман[OMN]");
        result.add("Остров Буве[BVT]");
        result.add("Остров Мэн[IMN]");
        result.add("Остров Норфолк[NFK]");
        result.add("Остров Рождества[CXR]");
        result.add("Остров Херд и острова Макдональд[HMD]");
        result.add("Острова Кайман[CYM]");
        result.add("Острова Кука[COK]");
        result.add("Острова Теркс и Кайкос[TCA]");
        result.add("Пакистан[PAK]");
        result.add("Палау[PLW]");
        result.add("Палестинская территория, оккупированная[PSE]");
        result.add("Панама[PAN]");
        result.add("Папский Престол (Государство — город Ватикан)[VAT]");
        result.add("Папуа-Новая Гвинея[PNG]");
        result.add("Парагвай[PRY]");
        result.add("Перу[PER]");
        result.add("Питкерн[PCN]");
        result.add("Польша[POL]");
        result.add("Португалия[PRT]");
        result.add("Пуэрто-Рико[PRI]");
        result.add("Республика Македония[MKD]");
        result.add("Реюньон[REU]");
        result.add("Россия[RUS]");
        result.add("Руанда[RWA]");
        result.add("Румыния[ROU]");
        result.add("Самоа[WSM]");
        result.add("Сан-Марино[SMR]");
        result.add("Сан-Томе и Принсипи[STP]");
        result.add("Саудовская Аравия[SAU]");
        result.add("Свазиленд[SWZ]");
        result.add("Святая Елена, Остров вознесения, Тристан-да-Кунья[SHN]");
        result.add("Северные Марианские острова[MNP]");
        result.add("Сен-Бартельми[BLM]");
        result.add("Сен-Мартен[MAF]");
        result.add("Сенегал[SEN]");
        result.add("Сент-Винсент и Гренадины[VCT]");
        result.add("Сент-Китс и Невис[KNA]");
        result.add("Сент-Люсия[LCA]");
        result.add("Сент-Пьер и Микелон[SPM]");
        result.add("Сербия[SRB]");
        result.add("Сейшелы[SYC]");
        result.add("Сингапур[SGP]");
        result.add("Синт-Мартен[SXM]");
        result.add("Сирийская Арабская Республика[SYR]");
        result.add("Словакия[SVK]");
        result.add("Словения[SVN]");
        result.add("Соединенное Королевство[GBR]");
        result.add("Соединенные Штаты[USA]");
        result.add("Соломоновы острова[SLB]");
        result.add("Сомали[SOM]");
        result.add("Судан[SDN]");
        result.add("Суринам[SUR]");
        result.add("Сьерра-Леоне[SLE]");
        result.add("Таджикистан[TJK]");
        result.add("Таиланд[THA]");
        result.add("Тайвань (Китай)[TWN]");
        result.add("Танзания, Объединенная Республика[TZA]");
        result.add("Тимор-Лесте[TLS]");
        result.add("Того[TGO]");
        result.add("Токелау[TKL]");
        result.add("Тонга[TON]");
        result.add("Тринидад и Тобаго[TTO]");
        result.add("Тувалу[TUV]");
        result.add("Тунис[TUN]");
        result.add("Туркмения[TKM]");
        result.add("Турция[TUR]");
        result.add("Уганда[UGA]");
        result.add("Узбекистан[UZB]");
        result.add("Украина[UKR]");
        result.add("Уоллис и Футуна[WLF]");
        result.add("Уругвай[URY]");
        result.add("Фарерские острова[FRO]");
        result.add("Фиджи[FJI]");
        result.add("Филиппины[PHL]");
        result.add("Финляндия[FIN]");
        result.add("Фолклендские острова (Мальвинские)[FLK]");
        result.add("Франция[FRA]");
        result.add("Французская Гвиана[GUF]");
        result.add("Французская Полинезия[PYF]");
        result.add("Французские Южные территории[ATF]");
        result.add("Хорватия[HRV]");
        result.add("Центрально-Африканская Республика[CAF]");
        result.add("Чад[TCD]");
        result.add("Черногория[MNE]");
        result.add("Чешская Республика[CZE]");
        result.add("Чили[CHL]");
        result.add("Швейцария[CHE]");
        result.add("Швеция[SWE]");
        result.add("Шпицберген и Ян Майен[SJM]");
        result.add("Шри-Ланка[LKA]");
        result.add("Эквадор[ECU]");
        result.add("Экваториальная Гвинея[GNQ]");
        result.add("Эландские острова[ALA]");
        result.add("Эль-Сальвадор[SLV]");
        result.add("Эритрея[ERI]");
        result.add("Эстония[EST]");
        result.add("Эфиопия[ETH]");
        result.add("Южная Африка[ZAF]");
        result.add("Южная Джорджия и Южные Сандвичевы острова[SGS]");
        result.add("Южная Осетия[OST]");
        result.add("Южный Судан[SSD]");
        result.add("Ямайка[JAM]");
        result.add("Япония[JPN]");


        return result;
    }

    static class WeigthDescription {
        Double Weigth;
        String Description;

        public WeigthDescription(Double weigth, String description) {
            Weigth = weigth;
            Description = description;
        }

        public Double getWeigth() {
            return Weigth;
        }

        public void setWeigth(Double weigth) {
            Weigth = weigth;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }
    }


}
