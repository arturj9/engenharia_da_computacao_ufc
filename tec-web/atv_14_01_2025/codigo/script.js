const buscaInput = document.getElementById('busca');
const limparBuscaBotao = document.getElementById('limparBusca');
const colaboradoresList = document.getElementById('colaboradores');
const novoColaboradorInput = document.getElementById('novoColaborador');
const addColaboradorBotao = document.getElementById('addColaborador');
const areaMsg = document.getElementById('areaMsg');

buscaInput.addEventListener('input', function () {
    const filter = buscaInput.value.toLowerCase();
    const colaboradores = colaboradoresList.getElementsByTagName('li');

    for (let colaborador of colaboradores) {
        const name = colaborador.textContent.toLowerCase();
        colaborador.style.display = name.includes(filter) ? '' : 'none';
    }
});

limparBuscaBotao.addEventListener('click', function () {
    buscaInput.value = '';
    const colaboradores = colaboradoresList.getElementsByTagName('li');
    for (let colaborador of colaboradores) {
        colaborador.style.display = '';
    }
});

addColaboradorBotao.addEventListener('click', function () {
    const name = novoColaboradorInput.value.trim();
    if (name) {
        const li = document.createElement('li');
        li.innerHTML = `${name} <button class="presencaBotao" onclick="registrarPresenca(this)">Registrar presença</button>`;
        colaboradoresList.appendChild(li);
        novoColaboradorInput.value = '';
    } else {
        alert('Por favor, informe um nome.');
    }
});

function registrarPresenca(button) {
    areaMsg.classList.add('show');
    limparMsg()
    const colaborador = button.parentElement.textContent.replace('Registrar presença', '').trim();
    const now = new Date();
    const timestamp = `${now.toLocaleDateString()} ${now.toLocaleTimeString()}`;
    const message = `Presença registrada para ${colaborador} em ${timestamp}`;
    const messageDiv = document.createElement('div');
    messageDiv.textContent = message;
    areaMsg.appendChild(messageDiv);
    setTimeout(() => {
        areaMsg.classList.remove('show');
        limparMsg();
    }, 3000);
}

function limparMsg() {
    areaMsg.innerText = '';
}