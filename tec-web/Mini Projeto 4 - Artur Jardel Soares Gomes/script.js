// Seletores de elementos do formulário
const form = document.getElementById('businessCardForm');
const msgs = document.getElementsByClassName("msg");

const nameInput = document.getElementById('name');
const professionInput = document.getElementById('profession');
const emailInput = document.getElementById('email');
const phoneInput = document.getElementById('phone');

const cardColorInput = document.getElementById('cardColor');
const nameColorInput = document.getElementById('nameColor');
const professionColorInput = document.getElementById('professionColor');
const emailColorInput = document.getElementById('emailColor');
const phoneColorInput = document.getElementById('phoneColor');

const nameBoldCheckbox = document.getElementById('nameBold');
const professionBoldCheckbox = document.getElementById('professionBold');
const emailBoldCheckbox = document.getElementById('emailBold');
const phoneBoldCheckbox = document.getElementById('phoneBold');

const previewName = document.getElementById('previewName');
const previewProfession = document.getElementById('previewProfession');
const previewEmail = document.getElementById('previewEmail');
const previewPhone = document.getElementById('previewPhone');
const cardPreview = document.getElementById('cardPreview');
const btnDownload = document.getElementById('download');
const bntReset = document.getElementById('resetBtn');

const logoInput = document.getElementById('logo');
const previewLogo = document.getElementById('previewLogo');

const updatePreview = () => {
    previewName.textContent = nameInput.value.trim() || "Seu Nome";
    previewProfession.textContent = professionInput.value.trim() || "Sua Profissão";
    previewEmail.textContent = emailInput.value.trim();
    previewPhone.textContent = phoneInput.value.trim();
};

const updateColors = () => {
    previewName.style.color = nameColorInput.value;
    previewProfession.style.color = professionColorInput.value;
    previewEmail.style.color = emailColorInput.value;
    previewPhone.style.color = phoneColorInput.value;
    cardPreview.style.backgroundColor = cardColorInput.value;
};

const updateFontWeight = () => {
    previewName.style.fontWeight = nameBoldCheckbox.checked ? 'bold' : 'normal';
    previewProfession.style.fontWeight = professionBoldCheckbox.checked ? 'bold' : 'normal';
    previewEmail.style.fontWeight = emailBoldCheckbox.checked ? 'bold' : 'normal';
    previewPhone.style.fontWeight = phoneBoldCheckbox.checked ? 'bold' : 'normal';
};

const updateLogo = () => {
    const file = logoInput.files[0];
    if (file) {
        if (!file.type.startsWith('image/')) {
            alert('Por favor, selecione um arquivo de imagem válido.');
            logoInput.value = '';
            return;
        }
        const reader = new FileReader();
        reader.onload = (e) => {
            previewLogo.src = e.target.result;
            previewLogo.style.display = 'block';
        };
        reader.readAsDataURL(file);
    } else {
        previewLogo.src = '';
        previewLogo.style.display = 'none';
    }
};

const resetForm = () => {
    form.reset();
    previewName.textContent = "Seu Nome";
    previewName.style.color = "#000000";
    previewProfession.textContent = "Sua Profissão";
    previewProfession.style.color = "#000000";
    previewEmail.textContent = "";
    previewPhone.textContent = "";
    cardPreview.style.backgroundColor = "#b8b4b4";
    nameColorInput.value = "#000000";
    professionColorInput.value = "#000000";
    emailColorInput.value = "#000000";
    phoneColorInput.value = "#000000";
    previewLogo.src = '';
    previewLogo.style.display = 'none';
    updateFontWeight();
};

const generateCard = () => {
    if (!nameInput.value.trim() && !professionInput.value.trim()) {
        msgs.item(0).style.display = 'block';
        msgs.item(0).innerHTML = 'Campo obrigatório.'
        msgs.item(1).style.display = 'block';
        msgs.item(1).innerHTML = 'Campo obrigatório.'
        return;
    }

    if (!nameInput.value.trim()) {
        msgs.item(0).style.display = 'block';
        msgs.item(0).innerHTML = 'Campo obrigatório.'
        return;
    }

    if (!professionInput.value.trim()) {
        msgs.item(1).style.display = 'block';
        msgs.item(1).innerHTML = 'Campo obrigatório.'
        return;
    }

    alert("Cartão criado com sucesso!");

    html2canvas(cardPreview).then(canvas => {
        const image = canvas.toDataURL('image/png');
        const safeFileName = nameInput.value.trim().replace(/[^a-z0-9_\-]/gi, '_');
        if (btnDownload) {
            btnDownload.href = image;
            btnDownload.download = `cartao-de-visita-${safeFileName}.png`;
            btnDownload.click();
        } else {
            const newTab = window.open();
            newTab.document.write('<img src="' + image + '" alt="Cartão de Visita"/>');
        }
    });
};

nameInput.addEventListener('input', () => {
    updatePreview()
    msgs.item(0).style.display = 'none';
    msgs.item(0).innerHTML = '';
});
professionInput.addEventListener('input', () => {
    updatePreview()
    msgs.item(0).style.display = 'none';
    msgs.item(1).innerHTML = '';
});
emailInput.addEventListener('input', updatePreview);
phoneInput.addEventListener('input', updatePreview);

nameColorInput.addEventListener('input', updateColors);
professionColorInput.addEventListener('input', updateColors);
emailColorInput.addEventListener('input', updateColors);
phoneColorInput.addEventListener('input', updateColors);
cardColorInput.addEventListener('input', updateColors);

nameBoldCheckbox.addEventListener('change', updateFontWeight);
professionBoldCheckbox.addEventListener('change', updateFontWeight);
emailBoldCheckbox.addEventListener('change', updateFontWeight);
phoneBoldCheckbox.addEventListener('change', updateFontWeight);

logoInput.addEventListener('change', updateLogo);

bntReset.addEventListener('click', resetForm);

form.addEventListener('submit', (event) => {
    event.preventDefault();
    generateCard();
});
