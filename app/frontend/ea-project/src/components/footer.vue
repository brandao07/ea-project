<template>
    <footer class="footer">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h5>Links Úteis</h5>
            <ul>
              <li><a href="#">Página Inicial</a></li>
              <li><a href="#">Sobre Nós</a></li>
              <li><a href="#">Ajuda</a></li>
            </ul>
          </div>
          <div class="col-md-6">
            <h5>Redes Sociais</h5>
            <ul>
              <li><a href="#">Facebook</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Instagram</a></li>
            </ul>
          </div>
        </div>
        <hr>
        <div class="text-center">
          <p>&copy; {{ currentYear }} Trabalho Escolar realizado no âmbito das UCs de Arquitetura de Computadores e Sistemas Interativos Confiáveis.</p>
        </div>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    name: 'Footer',
    data() {
      return {
        currentYear: new Date().getFullYear(),
      };
    },
  };
  </script>
  
  <style scoped>
  .footer {
    background-color: #f8f9fa;
    padding: 30px 0;
    color: #333;
    font-size: 14px;
  }
  
  .footer ul {
    list-style-type: none;
    padding: 0;
  }
  
  .footer ul li {
    margin-bottom: 10px;
  }
  
  .footer ul li a {
    color: #333;
    text-decoration: none;
  }
  
  .footer ul li a:hover {
    text-decoration: underline;
  }
  
  .text-center {
    text-align: center;
  }
  </style>
  