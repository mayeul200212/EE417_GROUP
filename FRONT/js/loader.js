document.addEventListener('DOMContentLoaded', () => {
    const mainContent = document.getElementById('main');

    // Function to load content
    function loadContent(pageName) {
        fetch(`${pageName}.html`)
            .then(response => response.text())
            .then(data => {
                mainContent.innerHTML = data;
            })
            .catch(error => console.error('Error loading the page: ', error));
    }

    // Initial load
    loadContent('home');

    // Event delegation for navigation links
    document.querySelector('nav').addEventListener('click', event => {
        if (event.target.tagName === 'A') {
            const pageName = event.target.getAttribute('data-page');
            loadContent(pageName);
            event.preventDefault();
        }
    });
});