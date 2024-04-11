

const barChartOptions = {
    series: [
        {
            data: [20, 25, 15, 10, 6],
        },
    ],
    chart: {
        type: 'bar',
        height: 350,
        toolbar: {
            show: false,
        },
    },
    colors: ['#246dec', '#cc3c43', '#367952', '#f5b74f', '#4f35a1'],
    plotOptions: {
        bar: {
            distributed: true,
            borderRadius: 4,
            horizontal: false,
            columnWidth: '40%',
        },
    },
    dataLabels: {
        enabled: false,
    },
    legend: {
        // show: false,
    },
    xaxis: {
        categories: ['Room 1', 'Room 2', 'Room 3', 'Room 4', 'Room 5'],
    },
    yaxis: {
        title: {
            text: 'Count',
        },
    },
};

const barChart = new ApexCharts(
    document.querySelector('#bar-chart'),
    barChartOptions
);
barChart.render();


const areaChartOptions = {
    series: [
        {
            name: 'Noise Level',
            data: [31, 40, 28, 51, 42, 109, 100],
        },
        {
            name: 'Air Quality',
            data: [11, 32, 45, 32, 34, 52, 41],
        },
    ],
    chart: {
        height: 350,
        type: 'area',
        toolbar: {
            show: false,
        },
    },
    colors: ['#4f35a1', '#246dec'],
    dataLabels: {
        enabled: false,
    },
    stroke: {
        curve: 'smooth',
    },
    labels: ['Area 1', 'Area 2', 'Area 3', 'Area 4', 'Area 5', ' Area 6', 'Area 7'],
    markers: {
        size: 0,
    },
    yaxis: [
        {
            title: {
                text: 'Noise Level dB',
            },
        },
        {
            opposite: true,
            title: {
                text: 'Air Quality %',
            },
        },
    ],
    tooltip: {
        shared: true,
        intersect: false,
    },
};

const areaChart = new ApexCharts(
    document.querySelector('#area-chart'),
    areaChartOptions
);
areaChart.render();


