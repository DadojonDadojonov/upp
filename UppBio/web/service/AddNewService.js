class AddNewService
{
    // Функция получает 2 json строки с контроллера, а потом отправляет 2 гет запроса с этими json строками на добавление ученого и его биографии
    AddNewDataService(jsonSci, jsonBio) {
        
        // GET-запрос на добавление ученого
        var request = new XMLHttpRequest();
        request.open('GET', '/UppBio/insertScientist?json=' + jsonSci, false); 
        request.send(); // отправить запрос        
       
        if (request.status != 200)
        {
            alert(request.status + ': ' + request.statusText);
            return null;
        } else
        {
            alert("Новые ученый добавлен");
        }
        
        /*-------------------------------------------------------------------------------------*/
        
        // GET-запрос на добавление его биографии
        var request = new XMLHttpRequest(); 
        request.open('GET', '/UppBio/insertBiography?json=' + jsonBio, false); 
        request.send();
        
        
        if (request.status != 200)
        {
            alert(request.status + ': ' + request.statusText);
            return null;
        } else 
        {
            alert("Новая биография добавлена");
        }
        
        // перезагрузка страницы
        location.reload()
    }
}