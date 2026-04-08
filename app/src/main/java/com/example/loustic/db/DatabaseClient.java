package com.example.loustic.db;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseClient {


    private static DatabaseClient instance;


    private AppDatabase appDatabase;


    private DatabaseClient(final Context context) {

        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").addCallback(roomDatabaseCallback).build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }


    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // ==========================================
            // MATIÈRE : ADDITIONS
            // ==========================================

            // --- Niveau 1
            insererQuestion(db, "addition", 1, "Combien font 2 + 3 ?", "5", "4", "6", "7");
            insererQuestion(db, "addition", 1, "Combien font 4 + 4 ?", "8", "6", "10", "9");
            insererQuestion(db, "addition", 1, "Combien font 5 + 2 ?", "7", "6", "8", "9");
            insererQuestion(db, "addition", 1, "Combien font 6 + 3 ?", "9", "8", "10", "7");
            insererQuestion(db, "addition", 1, "Combien font 7 + 1 ?", "8", "7", "9", "6");
            insererQuestion(db, "addition", 1, "Combien font 5 + 5 ?", "10", "9", "11", "15");
            insererQuestion(db, "addition", 1, "Combien font 8 + 2 ?", "10", "11", "9", "12");
            insererQuestion(db, "addition", 1, "Combien font 3 + 6 ?", "9", "8", "7", "10");
            insererQuestion(db, "addition", 1, "Combien font 4 + 5 ?", "9", "8", "10", "11");
            insererQuestion(db, "addition", 1, "Combien font 1 + 9 ?", "10", "8", "11", "9");
            insererQuestion(db, "addition", 1, "Combien font 10 + 2 ?", "12", "11", "13", "20");
            insererQuestion(db, "addition", 1, "Combien font 10 + 5 ?", "15", "14", "16", "105");
            insererQuestion(db, "addition", 1, "Combien font 11 + 3 ?", "14", "13", "15", "12");
            insererQuestion(db, "addition", 1, "Combien font 12 + 4 ?", "16", "15", "17", "18");
            insererQuestion(db, "addition", 1, "Combien font 15 + 2 ?", "17", "16", "18", "14");
            insererQuestion(db, "addition", 1, "Combien font 13 + 3 ?", "16", "15", "17", "12");
            insererQuestion(db, "addition", 1, "Combien font 14 + 5 ?", "19", "18", "20", "17");
            insererQuestion(db, "addition", 1, "Combien font 16 + 2 ?", "18", "17", "19", "20");
            insererQuestion(db, "addition", 1, "Combien font 17 + 1 ?", "18", "16", "19", "17");
            insererQuestion(db, "addition", 1, "Combien font 10 + 10 ?", "20", "100", "30", "10");

            // --- Niveau 2
            insererQuestion(db, "addition", 2, "Combien font 15 + 15 ?", "30", "20", "25", "35");
            insererQuestion(db, "addition", 2, "Combien font 24 + 12 ?", "36", "34", "38", "26");
            insererQuestion(db, "addition", 2, "Combien font 35 + 20 ?", "55", "50", "60", "45");
            insererQuestion(db, "addition", 2, "Combien font 42 + 15 ?", "57", "55", "67", "52");
            insererQuestion(db, "addition", 2, "Combien font 18 + 14 ?", "32", "30", "34", "22");
            insererQuestion(db, "addition", 2, "Combien font 27 + 16 ?", "43", "41", "45", "33");
            insererQuestion(db, "addition", 2, "Combien font 38 + 25 ?", "63", "61", "53", "65");
            insererQuestion(db, "addition", 2, "Combien font 49 + 12 ?", "61", "59", "63", "51");
            insererQuestion(db, "addition", 2, "Combien font 56 + 24 ?", "80", "70", "90", "76");
            insererQuestion(db, "addition", 2, "Combien font 64 + 17 ?", "81", "71", "83", "74");
            insererQuestion(db, "addition", 2, "Combien font 73 + 19 ?", "92", "82", "94", "83");
            insererQuestion(db, "addition", 2, "Combien font 45 + 45 ?", "90", "80", "100", "85");
            insererQuestion(db, "addition", 2, "Combien font 28 + 28 ?", "56", "54", "48", "66");
            insererQuestion(db, "addition", 2, "Combien font 37 + 37 ?", "74", "72", "64", "84");
            insererQuestion(db, "addition", 2, "Combien font 19 + 19 ?", "38", "36", "28", "48");
            insererQuestion(db, "addition", 2, "Combien font 55 + 26 ?", "81", "71", "83", "75");
            insererQuestion(db, "addition", 2, "Combien font 68 + 23 ?", "91", "81", "93", "88");
            insererQuestion(db, "addition", 2, "Combien font 47 + 34 ?", "81", "71", "91", "77");
            insererQuestion(db, "addition", 2, "Combien font 82 + 15 ?", "97", "87", "99", "92");
            insererQuestion(db, "addition", 2, "Combien font 50 + 49 ?", "99", "89", "100", "90");

            // --- Niveau 3
            insererQuestion(db, "addition", 3, "Combien font 150 + 250 ?", "400", "300", "500", "350");
            insererQuestion(db, "addition", 3, "Combien font 345 + 125 ?", "470", "460", "480", "450");
            insererQuestion(db, "addition", 3, "Combien font 550 + 350 ?", "900", "800", "1000", "850");
            insererQuestion(db, "addition", 3, "Combien font 725 + 175 ?", "900", "800", "1000", "850");
            insererQuestion(db, "addition", 3, "Combien font 1250 + 500 ?", "1750", "1650", "1800", "1700");
            insererQuestion(db, "addition", 3, "Combien font 2400 + 1600 ?", "4000", "3000", "5000", "3800");
            insererQuestion(db, "addition", 3, "Combien font 105 + 895 ?", "1000", "900", "1100", "990");
            insererQuestion(db, "addition", 3, "Combien font 432 + 268 ?", "700", "600", "800", "690");
            insererQuestion(db, "addition", 3, "Combien font 854 + 146 ?", "1000", "900", "1100", "990");
            insererQuestion(db, "addition", 3, "Combien font 375 + 375 ?", "750", "700", "800", "650");
            insererQuestion(db, "addition", 3, "Combien font 2080 + 1020 ?", "3100", "3000", "3200", "4000");
            insererQuestion(db, "addition", 3, "Combien font 4500 + 3500 ?", "8000", "7000", "9000", "7500");
            insererQuestion(db, "addition", 3, "Combien font 999 + 2 ?", "1001", "1000", "1011", "1002");
            insererQuestion(db, "addition", 3, "Combien font 199 + 350 ?", "549", "548", "550", "449");
            insererQuestion(db, "addition", 3, "Combien font 298 + 150 ?", "448", "449", "450", "348");
            insererQuestion(db, "addition", 3, "Combien font 1234 + 4321 ?", "5555", "5445", "5554", "5665");
            insererQuestion(db, "addition", 3, "Combien font 5050 + 5050 ?", "10100", "10000", "10500", "11000");
            insererQuestion(db, "addition", 3, "Combien font 7500 + 2500 ?", "10000", "9000", "11000", "9500");
            insererQuestion(db, "addition", 3, "Combien font 890 + 110 ?", "1000", "900", "1100", "990");
            insererQuestion(db, "addition", 3, "Combien font 365 + 365 ?", "730", "700", "760", "720");

            // ==========================================
            // MATIÈRE : MULTIPLICATIONS
            // ==========================================

            // --- Niveau 1
            insererQuestion(db, "multiplication", 1, "Combien font 2 x 3 ?", "6", "5", "8", "4");
            insererQuestion(db, "multiplication", 1, "Combien font 2 x 5 ?", "10", "8", "12", "7");
            insererQuestion(db, "multiplication", 1, "Combien font 2 x 8 ?", "16", "14", "18", "10");
            insererQuestion(db, "multiplication", 1, "Combien font 3 x 3 ?", "9", "6", "12", "8");
            insererQuestion(db, "multiplication", 1, "Combien font 3 x 4 ?", "12", "7", "14", "9");
            insererQuestion(db, "multiplication", 1, "Combien font 3 x 7 ?", "21", "18", "24", "27");
            insererQuestion(db, "multiplication", 1, "Combien font 3 x 9 ?", "27", "24", "30", "21");
            insererQuestion(db, "multiplication", 1, "Combien font 4 x 4 ?", "16", "12", "20", "8");
            insererQuestion(db, "multiplication", 1, "Combien font 4 x 5 ?", "20", "16", "24", "25");
            insererQuestion(db, "multiplication", 1, "Combien font 4 x 6 ?", "24", "20", "28", "26");
            insererQuestion(db, "multiplication", 1, "Combien font 4 x 8 ?", "32", "28", "36", "24");
            insererQuestion(db, "multiplication", 1, "Combien font 5 x 2 ?", "10", "15", "5", "12");
            insererQuestion(db, "multiplication", 1, "Combien font 5 x 5 ?", "25", "20", "30", "10");
            insererQuestion(db, "multiplication", 1, "Combien font 5 x 7 ?", "35", "30", "40", "25");
            insererQuestion(db, "multiplication", 1, "Combien font 5 x 9 ?", "45", "40", "50", "35");
            insererQuestion(db, "multiplication", 1, "Combien font 2 x 10 ?", "20", "10", "200", "12");
            insererQuestion(db, "multiplication", 1, "Combien font 3 x 10 ?", "30", "13", "300", "20");
            insererQuestion(db, "multiplication", 1, "Combien font 4 x 10 ?", "40", "14", "400", "44");
            insererQuestion(db, "multiplication", 1, "Combien font 5 x 10 ?", "50", "15", "500", "55");
            insererQuestion(db, "multiplication", 1, "Combien font 2 x 0 ?", "0", "2", "20", "1");

            // --- Niveau 2
            insererQuestion(db, "multiplication", 2, "Combien font 6 x 6 ?", "36", "30", "42", "32");
            insererQuestion(db, "multiplication", 2, "Combien font 6 x 7 ?", "42", "36", "48", "49");
            insererQuestion(db, "multiplication", 2, "Combien font 6 x 8 ?", "48", "42", "54", "56");
            insererQuestion(db, "multiplication", 2, "Combien font 6 x 9 ?", "54", "48", "60", "45");
            insererQuestion(db, "multiplication", 2, "Combien font 7 x 6 ?", "42", "36", "48", "49");
            insererQuestion(db, "multiplication", 2, "Combien font 7 x 7 ?", "49", "42", "56", "47");
            insererQuestion(db, "multiplication", 2, "Combien font 7 x 8 ?", "56", "54", "48", "64");
            insererQuestion(db, "multiplication", 2, "Combien font 7 x 9 ?", "63", "56", "70", "54");
            insererQuestion(db, "multiplication", 2, "Combien font 8 x 6 ?", "48", "42", "54", "56");
            insererQuestion(db, "multiplication", 2, "Combien font 8 x 7 ?", "56", "54", "48", "64");
            insererQuestion(db, "multiplication", 2, "Combien font 8 x 8 ?", "64", "56", "72", "60");
            insererQuestion(db, "multiplication", 2, "Combien font 8 x 9 ?", "72", "64", "81", "70");
            insererQuestion(db, "multiplication", 2, "Combien font 9 x 6 ?", "54", "48", "60", "45");
            insererQuestion(db, "multiplication", 2, "Combien font 9 x 7 ?", "63", "56", "70", "54");
            insererQuestion(db, "multiplication", 2, "Combien font 9 x 8 ?", "72", "64", "81", "70");
            insererQuestion(db, "multiplication", 2, "Combien font 9 x 9 ?", "81", "90", "72", "89");
            insererQuestion(db, "multiplication", 2, "Combien font 6 x 4 ?", "24", "20", "28", "18");
            insererQuestion(db, "multiplication", 2, "Combien font 7 x 3 ?", "21", "18", "24", "14");
            insererQuestion(db, "multiplication", 2, "Combien font 8 x 4 ?", "32", "24", "36", "28");
            insererQuestion(db, "multiplication", 2, "Combien font 9 x 3 ?", "27", "24", "30", "18");

            // --- Niveau 3
            insererQuestion(db, "multiplication", 3, "Combien font 10 x 15 ?", "150", "105", "1500", "115");
            insererQuestion(db, "multiplication", 3, "Combien font 20 x 5 ?", "100", "10", "205", "50");
            insererQuestion(db, "multiplication", 3, "Combien font 50 x 4 ?", "200", "20", "504", "100");
            insererQuestion(db, "multiplication", 3, "Combien font 30 x 3 ?", "90", "60", "900", "303");
            insererQuestion(db, "multiplication", 3, "Combien font 11 x 11 ?", "121", "111", "110", "131");
            insererQuestion(db, "multiplication", 3, "Combien font 12 x 12 ?", "144", "124", "140", "122");
            insererQuestion(db, "multiplication", 3, "Combien font 15 x 100 ?", "1500", "150", "15000", "10015");
            insererQuestion(db, "multiplication", 3, "Combien font 25 x 4 ?", "100", "75", "125", "150");
            insererQuestion(db, "multiplication", 3, "Combien font 12 x 3 ?", "36", "32", "46", "24");
            insererQuestion(db, "multiplication", 3, "Combien font 15 x 3 ?", "45", "35", "55", "50");
            insererQuestion(db, "multiplication", 3, "Combien font 20 x 20 ?", "400", "40", "200", "4000");
            insererQuestion(db, "multiplication", 3, "Combien font 50 x 20 ?", "1000", "100", "5000", "10000");
            insererQuestion(db, "multiplication", 3, "Combien font 14 x 2 ?", "28", "24", "26", "38");
            insererQuestion(db, "multiplication", 3, "Combien font 21 x 3 ?", "63", "61", "53", "33");
            insererQuestion(db, "multiplication", 3, "Combien font 99 x 0 ?", "0", "99", "990", "9");
            insererQuestion(db, "multiplication", 3, "Combien font 100 x 100 ?", "10000", "1000", "100000", "200");
            insererQuestion(db, "multiplication", 3, "Combien font 15 x 2 ?", "30", "20", "25", "40");
            insererQuestion(db, "multiplication", 3, "Combien font 25 x 2 ?", "50", "40", "45", "60");
            insererQuestion(db, "multiplication", 3, "Combien font 33 x 3 ?", "99", "66", "93", "89");
            insererQuestion(db, "multiplication", 3, "Combien font 50 x 50 ?", "2500", "250", "5000", "1000");


            // ==========================================
            // MATIÈRE : CULTURE GÉNÉRALE
            // ==========================================

            // --- Niveau 1
            insererQuestion(db, "culture_g", 1, "Quelle est la couleur du ciel quand il fait beau ?", "Bleu", "Vert", "Rouge", "Jaune");
            insererQuestion(db, "culture_g", 1, "Combien de pattes a un chien ?", "4", "2", "6", "8");
            insererQuestion(db, "culture_g", 1, "Quel animal donne du lait ?", "La vache", "La poule", "Le cochon", "Le cheval");
            insererQuestion(db, "culture_g", 1, "Combien y a-t-il de jours dans une semaine ?", "7", "5", "6", "8");
            insererQuestion(db, "culture_g", 1, "Quel fruit est jaune et allongé ?", "La banane", "La pomme", "Le citron", "La poire");
            insererQuestion(db, "culture_g", 1, "Où vivent les poissons ?", "Dans l eau", "Dans les arbres", "Sous la terre", "Dans les nuages");
            insererQuestion(db, "culture_g", 1, "Comment s appelle le bébé du chat ?", "Le chaton", "Le chiot", "Le poulain", "Le veau");
            insererQuestion(db, "culture_g", 1, "Que boivent les vaches ?", "De l eau", "Du lait", "Du jus", "Du soda");
            insererQuestion(db, "culture_g", 1, "Quel oiseau pond des œufs que l on mange au petit-déjeuner ?", "La poule", "Le pigeon", "L aigle", "Le moineau");
            insererQuestion(db, "culture_g", 1, "Quelle saison vient après l hiver ?", "Le printemps", "L automne", "L été", "La mousson");
            insererQuestion(db, "culture_g", 1, "Quel est le jour avant mardi ?", "Lundi", "Mercredi", "Jeudi", "Dimanche");
            insererQuestion(db, "culture_g", 1, "Combien de doigts as-tu sur une main ?", "5", "10", "4", "6");
            insererQuestion(db, "culture_g", 1, "Comment s appelle la maison des abeilles ?", "Une ruche", "Un nid", "Une niche", "Une écurie");
            insererQuestion(db, "culture_g", 1, "Avec quoi écris-tu à l école ?", "Un stylo", "Une fourchette", "Une brosse", "Un tournevis");
            insererQuestion(db, "culture_g", 1, "Quel objet sert à couper du papier ?", "Des ciseaux", "Une gomme", "Une règle", "Un pinceau");
            insererQuestion(db, "culture_g", 1, "Quel animal fait coin-coin ?", "Le canard", "Le dindon", "Le mouton", "L oie");
            insererQuestion(db, "culture_g", 1, "Quelle est la couleur du Soleil ?", "Jaune", "Bleu", "Vert", "Noir");
            insererQuestion(db, "culture_g", 1, "Quel véhicule roule sur des rails ?", "Le train", "La voiture", "L avion", "Le bateau");
            insererQuestion(db, "culture_g", 1, "Qui éteint les incendies ?", "Le pompier", "Le policier", "Le boulanger", "Le facteur");
            insererQuestion(db, "culture_g", 1, "Où achète-t-on le pain ?", "A la boulangerie", "A la pharmacie", "Au garage", "A la boucherie");

            // --- Niveau 2
            insererQuestion(db, "culture_g", 2, "Quelle est la capitale de la France ?", "Paris", "Lyon", "Marseille", "Bordeaux");
            insererQuestion(db, "culture_g", 2, "Combien de pattes a une araignée ?", "8", "6", "4", "10");
            insererQuestion(db, "culture_g", 2, "Quel est le fleuve qui traverse Paris ?", "La Seine", "Le Rhône", "La Loire", "La Garonne");
            insererQuestion(db, "culture_g", 2, "Combien y a-t-il de mois dans une année ?", "12", "10", "24", "11");
            insererQuestion(db, "culture_g", 2, "Dans quel pays se trouve la tour Eiffel ?", "La France", "L Italie", "L Espagne", "L Angleterre");
            insererQuestion(db, "culture_g", 2, "Qui était Charlemagne ?", "Un empereur", "Un explorateur", "Un peintre", "Un scientifique");
            insererQuestion(db, "culture_g", 2, "Quel oiseau ne vole pas ?", "L autruche", "Le perroquet", "L aigle", "La chouette");
            insererQuestion(db, "culture_g", 2, "Quel est le plus grand mammifère marin ?", "La baleine bleue", "Le requin", "Le dauphin", "L orque");
            insererQuestion(db, "culture_g", 2, "Combien de lettres y a-t-il dans l alphabet ?", "26", "24", "28", "22");
            insererQuestion(db, "culture_g", 2, "Quelle est la femelle du cheval ?", "La jument", "La pouliche", "La vache", "La brebis");
            insererQuestion(db, "culture_g", 2, "Quel est l océan situé à l ouest de la France ?", "L océan Atlantique", "L océan Pacifique", "L océan Indien", "La mer Méditerranée");
            insererQuestion(db, "culture_g", 2, "Que célèbre-t-on le 14 juillet en France ?", "La fête nationale", "Noël", "Pâques", "La fin de la guerre");
            insererQuestion(db, "culture_g", 2, "Quel instrument a des touches noires et blanches ?", "Le piano", "La guitare", "La batterie", "La flûte");
            insererQuestion(db, "culture_g", 2, "Quelle est la couleur du cheval blanc d Henri IV ?", "Blanc", "Noir", "Gris", "Marron");
            insererQuestion(db, "culture_g", 2, "Quel organe sert à respirer ?", "Les poumons", "Le cœur", "L estomac", "Le foie");
            insererQuestion(db, "culture_g", 2, "Comment appelle-t-on un triangle qui a 3 côtés égaux ?", "Equilatéral", "Isocèle", "Rectangle", "Quelconque");
            insererQuestion(db, "culture_g", 2, "Quelle est la capitale de l Italie ?", "Rome", "Venise", "Milan", "Naples");
            insererQuestion(db, "culture_g", 2, "Qui a peint la Joconde ?", "Léonard de Vinci", "Picasso", "Van Gogh", "Monet");
            insererQuestion(db, "culture_g", 2, "Sur quel continent se trouve la France ?", "L Europe", "L Afrique", "L Asie", "L Amérique");
            insererQuestion(db, "culture_g", 2, "Quel est le contraire du mot GENTIL ?", "Méchant", "Agréable", "Beau", "Grand");

            // --- Niveau 3
            insererQuestion(db, "culture_g", 3, "Quelle est la planète surnommée la planète rouge ?", "Mars", "Vénus", "Terre", "Jupiter");
            insererQuestion(db, "culture_g", 3, "En quelle année a eu lieu la Révolution française ?", "1789", "1515", "1914", "1945");
            insererQuestion(db, "culture_g", 3, "Quel est le plus grand océan du monde ?", "Le Pacifique", "L Atlantique", "L Indien", "L Arctique");
            insererQuestion(db, "culture_g", 3, "Combien de planètes compte notre système solaire ?", "8", "9", "7", "10");
            insererQuestion(db, "culture_g", 3, "Quelle est la capitale de l Espagne ?", "Madrid", "Barcelone", "Séville", "Lisbonne");
            insererQuestion(db, "culture_g", 3, "Qui a écrit Les Misérables ?", "Victor Hugo", "Molière", "Baudelaire", "Jules Verne");
            insererQuestion(db, "culture_g", 3, "Quel est le fleuve le plus long de France ?", "La Loire", "La Seine", "Le Rhône", "La Garonne");
            insererQuestion(db, "culture_g", 3, "De quoi est composé l essentiel de l air que nous respirons ?", "D azote", "D oxygène", "De dioxyde de carbone", "D hydrogène");
            insererQuestion(db, "culture_g", 3, "Quel est le plus grand continent du monde ?", "L Asie", "L Afrique", "L Amérique", "L Europe");
            insererQuestion(db, "culture_g", 3, "Qui était le roi Soleil ?", "Louis XIV", "Henri IV", "François Ier", "Louis XVI");
            insererQuestion(db, "culture_g", 3, "Quelle est la plus haute montagne du monde ?", "L Everest", "Le Mont Blanc", "Le Kilimandjaro", "L Annapurna");
            insererQuestion(db, "culture_g", 3, "En quelle année Christophe Colomb a-t-il découvert l Amérique ?", "1492", "1515", "1789", "1066");
            insererQuestion(db, "culture_g", 3, "Comment s appelle le mouvement de la Terre autour du Soleil ?", "La révolution", "La rotation", "La gravitation", "La translation");
            insererQuestion(db, "culture_g", 3, "Quelle est la capitale de l Allemagne ?", "Berlin", "Munich", "Francfort", "Vienne");
            insererQuestion(db, "culture_g", 3, "Que mesure-t-on avec un thermomètre ?", "La température", "La pression", "L humidité", "La vitesse du vent");
            insererQuestion(db, "culture_g", 3, "Quel est le résultat de 10 à la puissance 2 ?", "100", "20", "1000", "12");
            insererQuestion(db, "culture_g", 3, "Quel est le nom de notre galaxie ?", "La Voie lactée", "Andromède", "Orion", "La Grande Ourse");
            insererQuestion(db, "culture_g", 3, "Qui était Jeanne d Arc ?", "Une héroïne française", "Une reine", "Une écrivaine", "Une scientifique");
            insererQuestion(db, "culture_g", 3, "Quel animal est le symbole de la République française ?", "Le coq", "L aigle", "Le lion", "Le chien");
            insererQuestion(db, "culture_g", 3, "Quel est l angle d un angle droit ?", "90 degrés", "180 degrés", "45 degrés", "360 degrés");
        }

        // Méthode outil pour insérer facilement (inchangée)
        private void insererQuestion(SupportSQLiteDatabase db, String mat, int diff, String enonce, String bonne, String m1, String m2, String m3) {
            String req = "INSERT INTO question (matiere, difficulte, enonce, bonneReponse, mauvaiseReponse1, mauvaiseReponse2, mauvaiseReponse3) " +
                    "VALUES ('" + mat + "', " + diff + ", '" + enonce.replace("'", "''") + "', '" + bonne.replace("'", "''") + "', '" + m1.replace("'", "''") + "', '" + m2.replace("'", "''") + "', '" + m3.replace("'", "''") + "');";
            db.execSQL(req);
        }
    };
}
