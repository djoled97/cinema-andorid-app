package com.example.cinema.models;

import java.util.List;

public class MovieCredits {


    /**
     * id : 338762
     * cast : [{"cast_id":51,"character":"Ray Garrison / Bloodshot","credit_id":"5e85b6905294e700154a9a7c","gender":2,"id":12835,"name":"Vin Diesel","order":0,"profile_path":"/pDvArVo8MywQifHDP2JErfO8Sat.jpg"},{"cast_id":13,"character":"KT","credit_id":"5b060680c3a3684ca0003ca0","gender":1,"id":1222992,"name":"Eiza González","order":1,"profile_path":"/2EpyDXqw1oyJnKayu2XshczjiBN.jpg"},{"cast_id":15,"character":"Jimmy Dalton","credit_id":"5b0606939251410dd1004019","gender":2,"id":209326,"name":"Sam Heughan","order":2,"profile_path":"/v6wWNnDdTr2Ern93ljCkM6uEyUB.jpg"},{"cast_id":18,"character":"Martin Axe","credit_id":"5b32c9b5c3a368532801483f","gender":2,"id":20286,"name":"Toby Kebbell","order":3,"profile_path":"/mlYytYJvoEHmhDH2enLtES1098Q.jpg"},{"cast_id":16,"character":"Gina Garrison","credit_id":"5b2c11c3c3a36825880003d5","gender":1,"id":66441,"name":"Talulah Riley","order":4,"profile_path":"/6EtG9vwttacIeSJYss5aUabVikQ.jpg"},{"cast_id":25,"character":"Wilfred Wigens","credit_id":"5dac53b33876510017dd0851","gender":2,"id":1181327,"name":"Lamorne Morris","order":5,"profile_path":"/5WvdgaK4EIzoY5ZyQ31Nm0DxlEp.jpg"},{"cast_id":23,"character":"Dr. Emil Harting","credit_id":"5dac537a3876510013dcf3a3","gender":2,"id":529,"name":"Guy Pearce","order":6,"profile_path":"/vTqk6Nh3WgqPubkS23eOlMAwmwa.jpg"},{"cast_id":19,"character":"Nick Baris","credit_id":"5b36a245c3a368531102d07b","gender":2,"id":238164,"name":"Jóhannes Haukur Jóhannesson","order":7,"profile_path":"/kWYUvILe4v3EBhZVm3QOSCpZPJz.jpg"},{"cast_id":17,"character":"Tibbs","credit_id":"5b2c11f70e0a262ced000536","gender":2,"id":1472892,"name":"Alex Hernandez","order":8,"profile_path":"/zxgVPvrxYoyAZw2RQSAluHEXzdZ.jpg"},{"cast_id":24,"character":"Eric","credit_id":"5dac539b3876510013dcf408","gender":2,"id":1716711,"name":"Siddharth Dhananjay","order":9,"profile_path":"/rz2fIkfO13cvoDSlki6BjoBxcLF.jpg"},{"cast_id":27,"character":"Mombasa Gunman","credit_id":"5dac53de3876510017dd08a2","gender":2,"id":1838215,"name":"Tamer Burjaq","order":10,"profile_path":"/rz1FOttxvkeVkAh7XxjBwd8eGgC.jpg"},{"cast_id":31,"character":"Mombasa Hostage","credit_id":"5dac542b3876510010dcfc1d","gender":0,"id":1541472,"name":"Clyde Berning","order":11,"profile_path":"/ztyhbZULPpqtv1ncUuIJR7uiOKN.jpg"},{"cast_id":43,"character":"Merc Driver","credit_id":"5e7ac173eec4f30016a8a591","gender":2,"id":1184628,"name":"David Dukas","order":12,"profile_path":"/5LvqM7MOLxklChoN9BQF0KxktTz.jpg"},{"cast_id":32,"character":"Merc","credit_id":"5dac54393876510013dcf50c","gender":0,"id":1261817,"name":"Tyrel Meyer","order":13,"profile_path":"/mowoOqDvHBbpvj85NBSwjx12gF5.jpg"},{"cast_id":30,"character":"Baris Merc","credit_id":"5dac5419ae366800179829e5","gender":0,"id":1654627,"name":"Alex Anlos","order":14,"profile_path":"/lmJDDb00NeqxqCuTVezCeLWHKah.jpg"},{"cast_id":26,"character":"Tech #2","credit_id":"5dac53ca174a870015a813ba","gender":0,"id":2436897,"name":"Maarten Römer","order":15,"profile_path":"/gpnIbijkg1zWBoUMs7GicsV5IGm.jpg"},{"cast_id":52,"character":"Merc Leader","credit_id":"5ea5035c6d1bb20024a42e2d","gender":0,"id":1854853,"name":"Charlie Bouguenon","order":18,"profile_path":"/mhl0U2IxWDoj1dwMscVguug9sEs.jpg"},{"cast_id":53,"character":"Guard","credit_id":"5ea5039e7390c00020a5c4bd","gender":0,"id":1373437,"name":"Nic Rasenti","order":19,"profile_path":"/emKp6Re9lme4Gt2TJ9Sz0Ndtg6E.jpg"},{"cast_id":54,"character":"Ex-RST Employee","credit_id":"5ea503d235c30a001dbe7d81","gender":0,"id":2615141,"name":"Ryan Michael Sin","order":20,"profile_path":null},{"cast_id":55,"character":"Ex-RST Employee","credit_id":"5ea503ec3faba0002046a811","gender":2,"id":1210979,"name":"Michael Kirch","order":21,"profile_path":null},{"cast_id":56,"character":"Ex-RST Employee","credit_id":"5ea503fe18b751001f3857c5","gender":2,"id":1288410,"name":"Ryan Kruger","order":22,"profile_path":"/uA5jkdAoVniwAx3Z5CU2J4hn41W.jpg"},{"cast_id":57,"character":"Ex-RST Employee","credit_id":"5ea50418db72c00026bd28de","gender":0,"id":1769592,"name":"Austin Rose","order":23,"profile_path":null},{"cast_id":58,"character":"Ex-RST Employee","credit_id":"5ea5043366f2d200243eee5c","gender":0,"id":2615150,"name":"Gary Naidoo","order":24,"profile_path":null},{"cast_id":59,"character":"Ex-RST Employee","credit_id":"5ea5043fa2d2e90018dda1ac","gender":0,"id":2615151,"name":"Hilton Sun","order":25,"profile_path":null},{"cast_id":60,"character":"Ex-RST Employee","credit_id":"5ea5046a6d1bb20024a42f6e","gender":0,"id":2615153,"name":"Tsogt Baysgalan","order":26,"profile_path":null},{"cast_id":61,"character":"Police Officer #1","credit_id":"5ea50486a2d2e90018dda1ef","gender":0,"id":2615155,"name":"Donovan Goliath","order":27,"profile_path":null},{"cast_id":62,"character":"Gina's Daughter","credit_id":"5ea504a366f2d2001a3ef79b","gender":0,"id":2615156,"name":"Freyja Stern","order":28,"profile_path":null},{"cast_id":63,"character":"RST Tech","credit_id":"5ea504b5bdc34c001e26c048","gender":0,"id":1368127,"name":"Keeno Lee Hector","order":29,"profile_path":null},{"cast_id":64,"character":"RST Tech","credit_id":"5ea504e55a469000251146a8","gender":2,"id":1970931,"name":"Jeremy Jess Boado","order":30,"profile_path":"/jt7DaEeCYxhtlmqAeNXa1t29kiQ.jpg"},{"cast_id":65,"character":"RST Tech","credit_id":"5ea50522ec4552001f3ff190","gender":0,"id":2615158,"name":"Shelani Van Niekerk","order":31,"profile_path":null},{"cast_id":66,"character":"Police Officer #2","credit_id":"5ea50546a2d2e90021dd9be1","gender":0,"id":2615159,"name":"Jason Goliath","order":32,"profile_path":null},{"cast_id":67,"character":"Truck Driver (uncredited)","credit_id":"5ea50565a2d2e90021dd9c37","gender":2,"id":207818,"name":"Patrick Kerton","order":33,"profile_path":"/jj9uVCBSSUFvOi663jMbs7YJ3G3.jpg"}]
     * crew : [{"credit_id":"5dac5498174a870015a8143c","department":"Production","gender":2,"id":561,"job":"Casting","name":"John Papsidera","profile_path":"/egwEVyrAmdWhtuLqE5fcThZf41E.jpg"},{"credit_id":"59c18a919251412c0e00238f","department":"Production","gender":2,"id":957,"job":"Producer","name":"Matthew Vaughn","profile_path":"/Dnbz3B7yy4u0abixuD5LakZgsy.jpg"},{"credit_id":"5dac5489ae36680017982b28","department":"Editing","gender":2,"id":5546,"job":"Editor","name":"Jim May","profile_path":null},{"credit_id":"56b982c292514106af0015c6","department":"Production","gender":2,"id":11874,"job":"Producer","name":"Neal H. Moritz","profile_path":null},{"credit_id":"5bfa6a4392514104c7024dab","department":"Sound","gender":2,"id":18264,"job":"Original Music Composer","name":"Steve Jablonsky","profile_path":null},{"credit_id":"5dac54edb2681f001695bf92","department":"Costume & Make-Up","gender":1,"id":20359,"job":"Costume Design","name":"Kimberly A. Tillman","profile_path":null},{"credit_id":"5e7c74a5eec4f30547a901fc","department":"Writing","gender":2,"id":55075,"job":"Screenplay","name":"Jeff Wadlow","profile_path":"/8MquRXIWZ7t4YeOMvl68AX5Fb4b.jpg"},{"credit_id":"5e7c74cafea0d708fec83593","department":"Writing","gender":2,"id":55075,"job":"Story","name":"Jeff Wadlow","profile_path":"/8MquRXIWZ7t4YeOMvl68AX5Fb4b.jpg"},{"credit_id":"56b982cfc3a3681e680023b8","department":"Production","gender":0,"id":59920,"job":"Producer","name":"Toby Jaffe","profile_path":null},{"credit_id":"5e7c748113a32016dc26b9b3","department":"Writing","gender":2,"id":115033,"job":"Screenplay","name":"Eric Heisserer","profile_path":"/pFG6KLu3yNiiz2sHVKjdSMaPso5.jpg"},{"credit_id":"5e7c753213a32016dc26ba7f","department":"Writing","gender":2,"id":126824,"job":"Comic Book","name":"Kevin VanHook","profile_path":null},{"credit_id":"5dac54ad174a870019a80408","department":"Art","gender":2,"id":1002497,"job":"Production Design","name":"Tom Brown","profile_path":null},{"credit_id":"5b9df4700e0a26755d011987","department":"Camera","gender":0,"id":1186279,"job":"Director of Photography","name":"Jacques Jouffret","profile_path":null},{"credit_id":"5b9df4910e0a267565012870","department":"Art","gender":2,"id":1322142,"job":"Production Design","name":"Tom Brown","profile_path":null},{"credit_id":"5dac54c4174a870015a8146c","department":"Art","gender":2,"id":1325917,"job":"Supervising Art Director","name":"Simon Lamont","profile_path":null},{"credit_id":"5e6220628e2ba60014de560f","department":"Production","gender":1,"id":1365598,"job":"Executive Producer","name":"Cheryl Eatock","profile_path":null},{"credit_id":"5e62203f55c92600195abf9a","department":"Production","gender":1,"id":1365598,"job":"Line Producer","name":"Cheryl Eatock","profile_path":null},{"credit_id":"56b982ddc3a3681e5d0017a7","department":"Production","gender":0,"id":1574732,"job":"Producer","name":"Dinesh Shamdasani","profile_path":null},{"credit_id":"56b98306c3a3681e64001636","department":"Production","gender":0,"id":1574733,"job":"Executive Producer","name":"Jason Kothari","profile_path":null},{"credit_id":"5e85b6375aba320016e6e289","department":"Directing","gender":2,"id":1773871,"job":"Director","name":"Dave Wilson","profile_path":"/p7Usoy0kYv5WH66uxmrR1ERuio6.jpg"},{"credit_id":"5dac54dfae36680017982c2c","department":"Art","gender":0,"id":2048234,"job":"Set Decoration","name":"Michele Barfoot","profile_path":null},{"credit_id":"5e7c756213a32046b726e17c","department":"Writing","gender":0,"id":2414066,"job":"Comic Book","name":"Bob Layton","profile_path":null},{"credit_id":"5e7c7595d861af2f0ab78fb0","department":"Writing","gender":2,"id":2454197,"job":"Comic Book","name":"Don Perlin","profile_path":null}]
     */

    private int id;
    private List<CastBean> cast;
    private List<CrewBean> crew;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CastBean> getCast() {
        return cast;
    }

    public void setCast(List<CastBean> cast) {
        this.cast = cast;
    }

    public List<CrewBean> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewBean> crew) {
        this.crew = crew;
    }

    public static class CastBean {
        /**
         * cast_id : 51
         * character : Ray Garrison / Bloodshot
         * credit_id : 5e85b6905294e700154a9a7c
         * gender : 2
         * id : 12835
         * name : Vin Diesel
         * order : 0
         * profile_path : /pDvArVo8MywQifHDP2JErfO8Sat.jpg
         */

        private int cast_id;
        private String character;
        private String credit_id;
        private int gender;
        private int id;
        private String name;
        private int order;
        private String profile_path;

        public int getCast_id() {
            return cast_id;
        }

        public void setCast_id(int cast_id) {
            this.cast_id = cast_id;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }

    public static class CrewBean {
        /**
         * credit_id : 5dac5498174a870015a8143c
         * department : Production
         * gender : 2
         * id : 561
         * job : Casting
         * name : John Papsidera
         * profile_path : /egwEVyrAmdWhtuLqE5fcThZf41E.jpg
         */

        private String credit_id;
        private String department;
        private int gender;
        private int id;
        private String job;
        private String name;
        private String profile_path;

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }
}
