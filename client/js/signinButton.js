document.querySelector('.login-button').addEventListener('click', function() {
    window.location.href = 'dashboard.html';
});


document.addEventListener('DOMContentLoaded', function() {
    
    if (localStorage.getItem('token-info')) {
      window.location.href = "index.html"
    }
    document.querySelector('.login-button').addEventListener('click', function(e) {
        e.preventDefault();
        e.stopPropagation();
        success = do_login();
        document.getElementById('loading_spinner').style.display = 'none'; // Loading spinner needs to be adjusted for better display
        document.querySelector('.login-container').classList.remove('blur');
        if (success) {
        window.location.href="dashboard.html";
        } else {
        alert("Invalid username/password")
        }
    });
   });
   
   function do_login() {
   
    var email = $("#email").val();
    var pass = $("#password").val();
    let result = false;
    if (email != "" && pass != "") {
     
    document.getElementById('loading_spinner').style.display = 'block'; // Loading spinner needs to be adjusted for better display
    document.querySelector('.login-container').classList.add('blur'); //blurs everything except spinner

     $.ajax({
      type: 'post',
      async: false,
      cache: false,
      url: 'http://localhost:8081/login',
      xhrFields: {
       withCredentials: true
      },
      headers: {
       'Accept': 'application/json, text/plain, */*',
       'Content-Type':'application/x-www-form-urlencoded',
       "Access-Control-Allow-Origin": "*",
      },
      data: {
       email: email,
       username: email,
       password: pass
      },
      crossOrigin: true,
      success: function(data){
       localStorage.setItem('token-info', JSON.stringify(data));
       result = true;
      },
       error: function (data) {
        result = false;
       }
     });
    }
    return result;
}
   