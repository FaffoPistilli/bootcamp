document.addEventListener("DOMContentLoaded", () => {
    const downloadButton = document.getElementById("download-cv");

    downloadButton.addEventListener("click", () => {
        const element = document.body;
        const options = {
            margin: 0.5,
            filename: 'Fabriccio_Pistilli_CV.pdf',
            image: { type: 'jpeg', quality: 0.98 },
            html2canvas: { scale: 2 },
            jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
        };
        
        html2pdf().set(options).from(element).save();
    });

    const contactForm = document.createElement("form");
    contactForm.innerHTML = `
        <label for="message">Mensaje:</label>
        <input type="text" id="message" placeholder="Escribe tu mensaje aquí..." required>
        <button type="submit">Enviar</button>
        <p id="success-message" style="color: green; display: none;">¡Mensaje enviado con éxito!</p>
    `;
    document.getElementById("contacto").appendChild(contactForm);

    contactForm.addEventListener("submit", (event) => {
        event.preventDefault();
        
        const messageInput = document.getElementById("message");
        const successMessage = document.getElementById("success-message");

        console.log("Mensaje enviado:", messageInput.value);

        messageInput.value = "";
        successMessage.style.display = "block";

        setTimeout(() => {
            successMessage.style.display = "none";
        }, 3000);
    });
});
