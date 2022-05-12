; (function() {
	/**
 * For usage, visit Chart.js docs https://www.chartjs.org/docs/latest/
 */
	
	// change this to the id of your chart element in HMTL
	const pieCtx = document.getElementById('order-pie-chart')
	
	function getPieConfig(dataArr) {
		//
		return {
			type: 'doughnut',
			data: {
				datasets: [
					{
						data: dataArr,
						/**
						 * These colors come from Tailwind CSS palette
						 * https://tailwindcss.com/docs/customizing-colors/#default-color-palette
						 */
						backgroundColor: ['#facc15', '#3b82f6', '#ef4444', '#22c55e'],
						label: 'Dataset 1',
					},
				],
				labels: ['Đang chuẩn bị', 'Đang giao', 'Đã huỷ', 'Đã giao' ],
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
	}
	
	//Sửa sau
	let option = 3

	fetch(`http://localhost:8080/api_sale_admin/satus_chart?option=${option}`)
		.then(resp => resp.text())
		.then(data => {
			var pieData = data.substring(1, data.length - 1).split(',').map(Number);
			const pieConfig = getPieConfig(pieData)
			let chart = new Chart(pieCtx, pieConfig)
		})
})()

	; (function() {
		const lineConfig = {
			type: 'line',
			data: {
				labels: ['Quý 1', 'Quý 2', 'Quý 3', 'Quý 4'],
				datasets: [
					{
						label: 'Organic',
						/**
						 * These colors come from Tailwind CSS palette
						 * https://tailwindcss.com/docs/customizing-colors/#default-color-palette
						 */
						backgroundColor: '#0694a2',
						borderColor: '#0694a2',
						data: [43, 48, 40, 54],
						fill: false,
					},
					{
						label: 'Paid',
						fill: false,
						/**
						 * These colors come from Tailwind CSS palette
						 * https://tailwindcss.com/docs/customizing-colors/#default-color-palette
						 */
						backgroundColor: '#7e3af2',
						borderColor: '#7e3af2',
						data: [24, 50, 64, 74],
					},
				],
			},
			options: {
				responsive: true,
				/**
				 * Default legends are ugly and impossible to style.
				 * See examples in charts.html to add your own legends
				 *  */
				legend: {
					display: false,
				},
				tooltips: {
					mode: 'index',
					intersect: false,
				},
				hover: {
					mode: 'nearest',
					intersect: true,
				},
				scales: {
					x: {
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Month',
						},
					},
					y: {
						display: true,
						scaleLabel: {
							display: true,
							labelString: 'Value',
						},
					},
				},
			},
		}

		// change this to the id of your chart element in HMTL
		const lineCtx = document.getElementById('order-pie-line')
		window.myLine = new Chart(lineCtx, lineConfig)
	})()