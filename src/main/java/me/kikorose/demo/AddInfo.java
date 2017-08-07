public class AddInfo{



    @GetMapping("/addinfo")
    public String initDatabase(){
        Iterable<Info> infolist;
        ArrayList<Info>toadd = new ArrayList<>();

        Info newInfo1 = new Info();
        newInfo1.set( "John J Jingleheimer-Schmidt");

        Info newInfo2 = new Info();
        newInfo2.set("jjjschmidt@gmail.com");

        Info newInfo3 = new Info();
        newInfo3.set("Organization");

        Info newInfo4 = new Info();
        newInfo4.set("StartDate");

        Info newInfo5 = new Info();
        newInfo5.set("EndDate");


        toadd.add(newInfo1);
        toadd.add(newInfo2);
        toadd.add(newInfo3);
        toadd.add(newInfo4);
        toadd.add(newInfo5);

        infolist=toadd;

        infoRepo.save(infolist);

        return "addinfo";

    }
}