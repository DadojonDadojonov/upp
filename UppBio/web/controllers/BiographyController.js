class BiographyController {

    /*Класс управляет полученными данными из сервиса BiographyService*/


    // DATA
    // Создание функции с параметром id, которая создает объект BiographyService и при помощи функции в нем и id, возвращает данные(биографии ученого) 
    getBiographyByScientistIdController(id) {
        var service = new BiographyService(); //создает объект BiographyService
        return service.getBiographyByScientistIdService(id); //возвращает биографии
    }

    getBiographyByIdController(id) {

        var service = new BiographyService(); //создает объект BiographyService

        return service.getBiographyByIdService(id); //возвращает биографию по id
    }

    //VIEW
    // Работа с полученными данными из Сервиса и вставка в страницу html
    getBiographyByScientistIdViewList(id) {
        var data = this.getBiographyByScientistIdController(id); //вызывает функцию этого класса getBiographyByScientistIdController(id) и получает массив биографий ученых
        var res = ""; // пустая строчная переменная

        // цикл по всем биографиям массива data
        for (var i = 0; i < data.length; i++)
        {
            // записываем данные из массива по переменным
            var id = data[i].id;
            var country = data[i].country;
            var bio = data[i].bio;

            var dob = new Date(data[i].dob);// формат данных Date в js
            var dod = new Date(data[i].dod);// формат данных Date в js
            //массив для названия месяца
            var months = ['январь', 'февраль', 'март', 'апрель', 'май', 'июнь', 'июль', 'август', 'сентябрь', 'октябрь', 'ноябрь', 'декабрь'];

            var id_Scientists = data[i].id_Scientists;

            // оформляем html код в переменную res. date.getFullYear/getMonth() возвращают форматированную дату из милисек. months[] - возвращает название месяца 
            res += "<div onclick='biographyClick(" + id + ")' class='row onenews'>  " +
                    "<div class='jumbotron'>" +
                    "<h2> Страны: " + country +
                    "<p>" + months[dob.getMonth()] +
                    ", " + dob.getFullYear() +
                    " — " + months[dod.getMonth()] +
                    ", " + dod.getFullYear() + "</p> </h2>" +
                    "<br> <p>" + bio.substr(0, 300) + "...</p>" +
                    "</div>" +
                    "</div>";
        }
        var element = document.getElementById("biography"); // находим на странице элемент с id = biography
        element.innerHTML = res; // вставка туда строки res
    }

    //для отображения биографии на странице biography.html
    getBiographyByIdViewList(id) {
        var data = this.getBiographyByIdController(id);        
        var res = "";

        // записываем данные из массива по переменным
        var id = data.id;
        var country = data.country;
        var bio = data.bio;

        var dob = new Date(data.dob);// формат данных Date в js
        var dod = new Date(data.dod);// формат данных Date в js
        //массив для названия месяца
        var months = ['январь', 'февраль', 'март', 'апрель', 'май', 'июнь', 'июль', 'август', 'сентябрь', 'октябрь', 'ноябрь', 'декабрь'];

        var id_Scientists = data.id_Scientists;

        // оформляем html код в переменную res. date.getFullYear/getMonth() возвращают форматированную дату из милисек. months[] - возвращает название месяца 
        res += "<div class='row onenews'>" +
                "<div class='jumbotron'>" +
                "<h2> Страны: " + country + "</h2>" +
                "<p>" + months[dob.getMonth()] +
                ", " + dob.getFullYear() +
                " — " + months[dod.getMonth()] +
                ", " + dod.getFullYear() + "</p> </h2>" +
                "<br> <p>" + bio + "...</p>" +
                "</div>" +
                "</div>";


        var element = document.getElementById("oneBio"); // находим на странице элемент с id = biography
        element.innerHTML = res; // вставка туда строки res



    }

}


