const unitMap = {
	"HORARIA":"horas",
	"DIARIA":"dias",
	"SEMANAL":"semanas",
	"MENSAL":"meses"
}

function changeTipoServico(){
	let tipoSelect = document.getElementById("tipo_servico");
	let timeUnit = document.getElementById("time_unit");
	timeUnit.innerText = unitMap[tipoSelect.value];
}

window.onload = () => {changeTipoServico()}
