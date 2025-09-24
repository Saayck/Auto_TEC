 const form = document.getElementById("registerForm");
    const errorMsg = document.getElementById("errorMsg");

    form.addEventListener("submit", async (e) => {
      e.preventDefault();
      errorMsg.style.display = "none";
      errorMsg.textContent = "";

      const formData = new FormData(form);
      const data = Object.fromEntries(formData.entries());

      if (data.password !== data.confirm_password) {
        errorMsg.textContent = "Las contraseñas no coinciden.";
        errorMsg.style.display = "block";
        return;
      }

      try {
        const response = await fetch("http://localhost:3000/register", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(data),
        });

        const result = await response.json();

        if (response.ok) {
          alert(result.message);
          form.reset();
           window.location.href = "../Admin/LOGIN.HTML";
        } else {
          errorMsg.textContent = result.message || "Error desconocido";
          errorMsg.style.display = "block";
        }
      } catch (error) {
        errorMsg.textContent = "Error al conectar con el servidor.";
        errorMsg.style.display = "block";
      }
    });