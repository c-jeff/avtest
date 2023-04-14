/* PRODUCTS SAMPLE */
const products = [
  {
    id: 1,
    precio: 'S/ 19.50',
    subtitulo: 'Plancha x 30 Unidades',
    imagen: 'HuevoPardo.png',
    nombre: "Huevo Pardo Empacado",
    descripcion: "Pavo entero marinado embolsado.",
    tipoDeEnvase: "Bolsa termoencogible sellada al vacío.",
    tiempoDeVidaUtil: "18 meses a temperaturas de congelación min -18 °C",
    almacenamiento: "A temperatura de refrigeración min de -18 °C.",
    reconstitucion: "N.A",
    formaDeConsumo: "El producto requiere cocción completa, manteniendo una temperatura interna mayor a 74°C - Público en general",
  },
  {
    id: 2,
    precio: 'S/ 141.55',
    subtitulo: 'Rango de 9 a 10kg',
    imagen: 'PavoMarinado.png',
    nombre: "Pavo Entero Marinado Avinka",
    descripcion: "Pavo entero marinado embolsado.",
    tipoDeEnvase: "Bolsa termoencogible sellada al vacío.",
    tiempoDeVidaUtil: "18 meses a temperaturas de congelación min -18 °C",
    almacenamiento: "A temperatura de refrigeración min de -18 °C.",
    reconstitucion: "N.A",
    formaDeConsumo: "El producto requiere cocción completa, manteniendo una temperatura interna mayor a 74°C - Público en general",
  },
  {
    id: 3,
    precio: 'S/ 33.90',
    subtitulo: 'Combo Cyber',
    imagen: 'SupremaPollo.png',
    nombre: "Suprema de Pollo + Pop corn Chicken",
    descripcion: "Deliciosa combinación de una suprema de pollo con un toque de sabor agridulce y pop corn chicken para una experiencia única y crujiente.",
    tipoDeEnvase: "Caja de cartón con compartimentos individuales para cada producto.",
    tiempoDeVidaUtil: "3 días a temperaturas de refrigeración max de 4 °C",
    almacenamiento: "Mantener refrigerado a una temperatura máxima de 4 °C.",
    reconstitucion: "N.A",
    formaDeConsumo: "Calentar en horno convencional a 180 °C por 10-12 minutos para obtener el mejor sabor y textura."
  },
  {
    id: 4,
    precio: 'S/ 14.90',
    subtitulo: 'De Pollo - Caja x 4 und',
    imagen: 'HamburguesaPollo.png',
    nombre: "Hamburguesa de Pollo",
    descripcion: "Deliciosa combinación de una suprema de pollo con un toque de sabor agridulce y pop corn chicken para una experiencia única y crujiente.",
    tipoDeEnvase: "Caja de cartón con compartimentos individuales para cada producto.",
    tiempoDeVidaUtil: "3 días a temperaturas de refrigeración max de 4 °C",
    almacenamiento: "Mantener refrigerado a una temperatura máxima de 4 °C.",
    reconstitucion: "N.A",
    formaDeConsumo: "Calentar en horno convencional a 180 °C por 10-12 minutos para obtener el mejor sabor y textura."
  },
  {
    id: 5,
    precio: 'S/ 13.50',
    subtitulo: 'Bandeja de 15 unidades',
    imagen: 'HuevoArtisan.webp',
    nombre: "Huevo Artisan - Gallinas Libres de Jaulas",
    descripcion: "Deliciosa combinación de una suprema de pollo con un toque de sabor agridulce y pop corn chicken para una experiencia única y crujiente.",
    tipoDeEnvase: "Caja de cartón con compartimentos individuales para cada producto.",
    tiempoDeVidaUtil: "3 días a temperaturas de refrigeración max de 4 °C",
    almacenamiento: "Mantener refrigerado a una temperatura máxima de 4 °C.",
    reconstitucion: "N.A",
    formaDeConsumo: "Calentar en horno convencional a 180 °C por 10-12 minutos para obtener el mejor sabor y textura."
  },
  {
    id: 6,
    precio: 'S/ 6.70',
    subtitulo: 'Listo para calentar y servir - Doypack 425 gr.',
    imagen: 'Garbanzo.png',
    nombre: "Garbanzos",
    descripcion: "Garbanzo entero marinado embolsado.",
    tipoDeEnvase: "Bolsa termoencogible sellada al vacío.",
    tiempoDeVidaUtil: "18 meses a temperaturas de congelación min -18 °C",
    almacenamiento: "A temperatura de refrigeración min de -18 °C.",
    reconstitucion: "N.A",
    formaDeConsumo: "El producto requiere cocción completa, manteniendo una temperatura interna mayor a 74°C - Público en general",
  },
  {
    id: 7,
    precio: 'S/ 9.40',
    subtitulo: 'Bolsa x 400gr.',
    imagen: 'Yuca.png',
    nombre: "Yuca amarilla precocida Cong.",
    descripcion: "Pavo entero marinado embolsado.",
    tipoDeEnvase: "Bolsa termoencogible sellada al vacío.",
    tiempoDeVidaUtil: "18 meses a temperaturas de congelación min -18 °C",
    almacenamiento: "A temperatura de refrigeración min de -18 °C.",
    reconstitucion: "N.A",
    formaDeConsumo: "El producto requiere cocción completa, manteniendo una temperatura interna mayor a 74°C - Público en general",
  },
]

function redirigirPagina() {
  window.location.href = "product-detail.html";
}

document.getElementById("searcher").addEventListener("keydown", function (event) {
  if (event.key === "Enter") window.location.href = "./search-products.html";
});


const container = document.getElementById("products");

function generarProducto(producto) {
  return `
    <div class="product-item" onclick="redirigirPagina()">
      <div class="product-img-container">
        <img class="product-img" src="../static/assets/images/products/${producto.imagen}" alt="${producto.nombre}">
      </div>
      <div class="product-favorite">
        <div class="favorite-icon">
          <i class="fa-regular fa-heart"></i>
        </div>
      </div>
      <p id="name">${producto.nombre}</p>
      <p id="description">${producto.subtitulo}</p>
      <p id="price">${producto.precio}</p>
      <p id="igv">Incluye IGV</p>
      <button class="product-add">
        +
      </button>
    </div>
  `;
}

for (let i = 0; i < products.length; i++) {
  const html = generarProducto(products[i]);
  container.insertAdjacentHTML('beforeend', html);
}

/* ASSISTANT */

/* const assistant = document.getElementById("assistant");

assistant.addEventListener("mousedown", () => {
  assistant.style.backgroundColor = "#87e087";
  console.log('hola')
});

assistant.addEventListener("mouseup", () => {
  assistant.style.backgroundColor = "transparent";
}); */

