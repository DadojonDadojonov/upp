class BiographyService {

    /* Класс отправляет GET запрос к серверу(согласно его api), и получает строку формата JSON.
     * Далее функция "JSON.parse(request.responseText)" создает из 
     *  json-строки массив данных с аналогичными названиями. 
     */

    getBiographyByScientistIdService(id) {

        // GET-запрос к серверу, который получает все биографии определенного ученого по id 

        var request = new XMLHttpRequest(); // Объект XMLHttpRequest (или, сокращенно, XHR) дает возможность браузеру делать HTTP-запросы к серверу без перезагрузки страницы.
        request.open('GET', '/UppBio/getScientist?id=' + id, false); // открывает GET запрос и по какой ссылке обращаться, false - синхронный запрос(ждет загрузки данных)
        request.send(); // отправить запрос

        //если любой код, кроме 200, выводит ошибку
        if (request.status != 200)
        {
            alert(request.status + ': ' + request.statusText);
            return null;
        } else //иначе все ок
        {
            /* request.responseText - возвращает текст ответа; JSON.parse() - парсит полученную json строку в массив */
            var scientist = JSON.parse(request.responseText); //получает ученого по id(но у него внутри есть список его биографий)

            return scientist.biography; //возвращает массив биографий ученого
        }
    }

    // биография по ID
    getBiographyByIdService(id) {
        var request = new XMLHttpRequest();
        request.open('GET', '/UppBio/getBiography?id=' + id, false);
        request.send();
        if (request.status != 200) {
            alert(request.status + ': ' + request.statusText);
            return null;
        } else {
            var biography = JSON.parse(request.responseText);            
            return biography;
        }
    }
}



