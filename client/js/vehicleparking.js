google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

const data = google.visualization.arrayToDataTable([
  ['Vehicles', 'Count'],
  ['Vehicles In',28],
  ['Vehicles Out',15],
  
]);


const options = {
  title:'Vehicles In and Out'
};


const chart = new google.visualization.PieChart(document.getElementById('myChart'));
chart.draw(data, options);


const data2 = google.visualization.arrayToDataTable([
    ['Vehicles', 'Count'],
    ['Two Wheeler',10],
    ['Four Wheeler',15],
    ['Three Wheeler',3]

    
  ]);
  

  const options2 ={
    title: 'Category of Vehicles'
  };

  const chart2 =new google.visualization.PieChart(document.getElementById('myChart2'));
  chart2.draw(data2, options2);

}




