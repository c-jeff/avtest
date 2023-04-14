
const burger_btn = document.getElementById('burger-btn');

const categories = document.getElementById('id-categories');
const navbar_options = document.getElementById('id-navbar-options');

const icon_bars = document.getElementById('fa-bars');
const icon_xmark = document.getElementById('fa-xmark');

burger_btn.addEventListener('click', function() {
  if (icon_bars.style.display === 'block') {
    icon_bars.style.display = 'none';
    icon_xmark.style.display = 'block';

    categories.style.display = 'block';
    navbar_options.style.display = 'flex';

  } else {
    icon_bars.style.display = 'block';
    icon_xmark.style.display = 'none';

    categories.style.display = 'none';
    navbar_options.style.display = 'none';
  }
});

window.addEventListener('resize', function() {
  categories.style.display = 'none';
  input_container.style.display = 'none';

  /* icon_bars.style.display = 'none'; */
  
  if (window.innerWidth >= 1024) {
    navbar_options.style.display = 'flex';
    icon_xmark.style.display = 'none';
    icon_bars.style.display = 'block';


  }
  else {
    navbar_options.style.display = 'none';
    open_search.style.display = 'block';
    
  }
});


const open_search = document.getElementById('search-open');
const close_search = document.getElementById('search-close');
const input_container = document.getElementById('input-container');

open_search.addEventListener('click', function() {
  if (open_search.style.display === 'block') {
    open_search.style.display = 'none';
    close_search.style.display = 'block';

    input_container.style.display = 'flex';
  }
});

close_search.addEventListener('click', function() {
  if (close_search.style.display === 'block') {
    close_search.style.display = 'none';
    open_search.style.display = 'block';

    input_container.style.display = 'none';
  }
});