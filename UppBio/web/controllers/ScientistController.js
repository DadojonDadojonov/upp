class ScientistController
{
    // все аналогично BiographyController
// DATA  
    getAllScientistsController()
    {
        
        var service = new ScientistService();
        return service.getAllScientistsService();
    }
    
// VIEW
    getAllScientistsViewButtons()
    {
        
        var data = this.getAllScientistsController();        
        var res = "";
        
        // onclick='scientistClick(...) обрабатывается на самой странице html
        for (var i = 0; i < data.length; i++)
        {
            res += "<div class='row'><button type='button' onclick='scientistClick(" + data[i].id_Scientist + ")'     class='btn btn-default col-md-11 col-sm-11'>" + data[i].name + "</button></div>";
        }
        
        var element = document.getElementById("scientists"); //находит элемент на странице с id = scientist
        element.innerHTML = res; // вписывает туда строчку res
    }

}

