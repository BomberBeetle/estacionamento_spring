function estacionamentoDropdownChanged(){
	let id = document.getElementById("estacionamento_selector").value;
	fetch("/estacionamento/" + id).then((response) => response.json())
		.then(
		(estacionamento) => {
			console.log(estacionamento);
			document.getElementById("taxa_base").value = estacionamento.taxa_base;

			document.getElementById("taxa_horaria").value = estacionamento.taxa_horaria;

			document.getElementById("taxa_diaria").value = estacionamento.taxa_diaria;

			document.getElementById("taxa_semanal").value = estacionamento.taxa_semanal;

			document.getElementById("taxa_mensal").value = estacionamento.taxa_mensal;
		}
	)
	.catch(
		(error) => {console.log(error)}
	);

}

window.onload = estacionamentoDropdownChanged;
