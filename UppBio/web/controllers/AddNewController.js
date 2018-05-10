class AddNewController
{

    addNewSci_biogr() {
        
        var Sci_id =  document.getElementById("Sci_id").value;//считать с элемента с id "Sci_id"
        var Sci_name = document.getElementById("Sci_name").value; //считать с элемента с id "Sci_name"
        var Sci_country = document.getElementById("Sci_country").value; //считать с элемента с id "Sci_country"
        var Sci_bio = document.getElementById("Sci_bio").value; //<...> "Sci_bio"
        var Sci_dob = Date.parse(document.getElementById("dob").value); // из даты в милисек
        var Sci_dod = Date.parse(document.getElementById("dod").value); // из даты в милисек
        
        // получается такой формат: {"id":11,"country":"Coun","bio":"Bioo","dob":1527444000000,"dod":1527703200000,"id_Scientist":5} 
        var jsonBio = "{\"id\":"+Sci_id+",\"country\":\"" + Sci_country + "\",\"bio\":\"" + Sci_bio + "\", \"dob\":" + Sci_dob + ", \"dod\":" + Sci_dod + ",\"id_Scientist\":" + Sci_id + "}";
        // получается такой формат: {"id_Scientist":11,"name":"Lomonosov"}
        var jsonSci = "{\"id_Scientist\":"+ Sci_id +",\"name\":\""+ Sci_name +"\"}";
        alert(jsonBio);
        alert(jsonSci);
       
       // создается объект AddNewService
        var service = new AddNewService();
        //используем функцию, передавая ей 2 полученные выше json строки
        service.AddNewDataService(jsonSci, jsonBio);       

    }

}