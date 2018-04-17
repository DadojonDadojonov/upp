class ScientistService
{
    
    /* Класс отправляет GET запрос к серверу(согласно его api), и получает строку формата JSON.
     * Далее функция "JSON.parse(request.responseText)" создает из 
     *  json-строки массив данных с аналогичными названиями. 
     */
    
    // возвращает всех ученых
    getAllScientistService() {
        // запрос к серверу GetAllScientists

        var request = new XMLHttpRequest(); // Объект XMLHttpRequest (или, сокращенно, XHR) дает возможность браузеру делать HTTP-запросы к серверу без перезагрузки страницы.
        request.open('GET', '/UppBio/getAllScientists', false); // открывает GET запрос и по какой ссылке обращаться, false - синхронный запрос(ждет загрузки данных)
        request.send(); // отправить запрос
       
       //если код 200, то все ок
        if (request.status == 200)
        {
            /* request.responseText - возвращает текст ответа; JSON.parse() - парсит полученную json строку в массив */
            var scientists = JSON.parse(request.responseText);
            return scientists;
        } 
        else //иначе выводит ошибку
        {
            alert(request.status + ': ' + request.statusText);
            return null;
        }
    }

    // возвращает ученого по id
    getScientistByIdService(id) {
        
        // запрос к серверу /getScientist?id=3
        
        var request = new XMLHttpRequest();
        request.open('GET', '/UppBio/getScientist?id=' + id, false);
        request.send();
        if (request.status == 200)
        {            
            var scientists = JSON.parse(request.responseText);
            return scientists;  
        } else
        {
            alert(request.status + ': ' + request.statusText);
            return null;
        }
    }


    getBiographyByScientistId(id) {
        var scientists = this.getScientistByIdService(id);
        return scientists.biography;
    }

}



