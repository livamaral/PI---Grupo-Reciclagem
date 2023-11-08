document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const msgSuccess = document.getElementById("msgSuccess");
  
    form.addEventListener("submit", async function (event) {
      event.preventDefault(); // Evita o envio padrão do formulário
  
      const formData = new FormData(form);
  
      try {
        const response = await fetch("/create-ecosenac", {
          method: "POST",
          body: formData,
        });
  
        if (response.ok) {
          // O cadastro foi bem-sucedido
          msgSuccess.innerHTML = "Cadastro realizado com sucesso!";
          form.reset(); // Limpa o formulário
  
          // Você pode redirecionar o usuário para outra página aqui, se necessário.
        } else {
          // Trate erros se necessário
          msgSuccess.innerHTML = "Erro ao cadastrar. Tente novamente.";
        }
      } catch (error) {
        console.error("Erro ao enviar o formulário:", error);
        msgSuccess.innerHTML = "Erro ao cadastrar. Tente novamente.";
      }
    });
  });
  