var ajaxUrl = 'http://localhost:8081/loggedInUser';
var user = null;

function checkdLoggedInUser() {
    localStorage.removeItem('token-info');
    let result = false;
    $.ajax({
        url: ajaxUrl,
        type: 'GET',
        async: false,
        cache: false,
        xhrFields: {
            withCredentials: true
        },
        crossOrigin: true,
        success: function(data){
            let value = JSON.stringify(data);
            localStorage.setItem('token-info', value);
            user = value;
            result = true;
        },
        error: function (data) {
            localStorage.removeItem('token-info');
            user = null;
        }
    });
    return result;
}

