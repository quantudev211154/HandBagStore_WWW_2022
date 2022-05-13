;(function(){
  /**
   * For usage, visit Chart.js docs https://www.chartjs.org/docs/latest/
   */
  const pieConfig = {
    type: 'doughnut',
    data: {
      datasets: [
        {
          data: [123, 308],
          /**
           * These colors come from Tailwind CSS palette
           * https://tailwindcss.com/docs/customizing-colors/#default-color-palette
           */
          backgroundColor: ['#3b82f6', '#22c55e'],
          label: 'Dataset 1',
        },
      ],
      labels: ['Nam', 'Nữ'],
    },
    options: {
      responsive: true,
      cutoutPercentage: 80,
      /**
       * Default legends are ugly and impossible to style.
       * See examples in charts.html to add your own legends
       *  */
      legend: {
        display: false,
      },
    },
  }

  // change this to the id of your chart element in HMTL
  const pieCtx = document.getElementById('order-pie-chart')

  let chart = new Chart(pieCtx, pieConfig)

})()