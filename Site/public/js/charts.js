var capacidadeMemoria = document.getElementById('chartMemoria').getContext('2d');
var chart = new Chart(capacidadeMemoria, {
    type: 'line',
    data:{
        labels: ["Jan", "Fev", "Mar", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"],
        datasets: [
            {
                label: "Uso da Memória",
                backgroundColor: '#fff',
                borderColor: '#f48ec',
                data: [50, 30, 20, 60, 35, 55, 90, 80, 100, 66, 99, 100],
            }
        ]
    }
});

var desempenhoCpu = document.getElementById('chartCpu').getContext('2d');
var chart = new Chart(desempenhoCpu, {
    type: 'line',
    data: {
        labels: ["Jan", "Fev","Abr", "Mar", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"],
        datasets: [
            {
                label: "% de Utilização",
                backgroundColor: '#fff',
                borderColor: '#38d6eb',
                data: [5000, 3000, 2000, 6000, 3500, 5500, 9000, 8000, 1000],
            }
        ]
    }
});