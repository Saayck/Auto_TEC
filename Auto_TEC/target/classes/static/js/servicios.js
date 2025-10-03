document.getElementById('cuotasForm').addEventListener('submit', function(e) {
      e.preventDefault();
      
      const monto = parseFloat(document.getElementById('monto').value);
      const inicial = parseFloat(document.getElementById('inicial').value) || 0;
      const plazo = parseInt(document.getElementById('plazo').value);
      const tasaAnual = parseFloat(document.getElementById('tasa').value);
      
      if (!monto || !plazo || !tasaAnual) {
        alert('Por favor, complete todos los campos requeridos');
        return;
      }
      
      const montoFinanciar = monto - inicial;
      const tasaMensual = tasaAnual / 100 / 12;
      
      const cuotaMensual = montoFinanciar * (tasaMensual * Math.pow(1 + tasaMensual, plazo)) / (Math.pow(1 + tasaMensual, plazo) - 1);
      const totalPagar = cuotaMensual * plazo;
      const totalIntereses = totalPagar - montoFinanciar;
      
      document.getElementById('montoFinanciar').textContent = `$${montoFinanciar.toFixed(2)}`;
      document.getElementById('cuotaMensual').textContent = `$${cuotaMensual.toFixed(2)}`;
      document.getElementById('totalIntereses').textContent = `$${totalIntereses.toFixed(2)}`;
      document.getElementById('totalPagar').textContent = `$${totalPagar.toFixed(2)}`;
      
      document.getElementById('resultBox').classList.add('show');
    });
    
    document.getElementById('cuotasModal').addEventListener('hidden.bs.modal', function () {
      document.getElementById('cuotasForm').reset();
      document.getElementById('resultBox').classList.remove('show');
    });