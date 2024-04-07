document.addEventListener('DOMContentLoaded', function() {
    // Query all elements with the class 'login-button'
    var loginButtons = document.querySelectorAll('.login-button');

    // Iterate through the NodeList and attach the event listener to each button
    loginButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            window.location.href = 'login.html';
        });
    });
});