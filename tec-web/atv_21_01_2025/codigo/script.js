const botaoBuscar = document.getElementById("buscar")
const botaoLimpar = document.getElementById("limpar")
const inputBuscar = document.getElementById("buscarPais");
const divPais = document.getElementById("pais");

botaoBuscar
  .addEventListener("click", () => {

    const nomePais = inputBuscar.value.trim().toLowerCase();
    if (nomePais == "") {
      alert("Por favor, insira um nome de país válido");
      return;
    }

    const apiURL = "https://restcountries.com/v3.1/name/";
    const request = apiURL + nomePais

    fetch(request).then((response) => {
      if (!response.ok) {
        throw new Error("Erro ao buscar os dados");
      }
      return response.json();
    }).then((data) => {
      const pais = data[0];

      divPais.innerHTML = `
        <h2>${pais.translations.por.common} - ${pais.translations.por.official}</h2>
        <p><strong>Capital:</strong> ${pais.capital}</p>
        <p><strong>População:</strong> ${pais.population}</p>
        <p><strong>Região:</strong> ${pais.region}</p>
        <img src="${pais.flags.png}" alt="pais.flags.alt">
        `;

    }).catch(error => {
      divPais.innerHTML = `<p style="color:red;">Erro ao carregar os dados: ${error.message}</p>`
    })
  })

botaoLimpar.addEventListener("click", () => {
  divPais.innerHTML = "<p>As informações foram limpas.</p>";
  inputBuscar.value = "";
})
