$(document).ready(function () {
    $.ajax({
         url: 'https://rickandmortyapi.com/api/character/',
         method: 'GET',
          success: function (data) {
                 const characters = data.results;
                 characters.forEach(function (character) {
                    $('#personajesList').append(`
                        <div class="character-card">
                               <img src="${character.image}" alt="${character.name}" class="character-image">
                            <div class="character-info">
                                <h2>${character.name}</h2>
                                <p><strong>Especie:</strong> ${character.species} - ${character.status}</p>
                                <p><strong>Última ubicación conocida:</strong> ${character.location.name}</p>
                                <p><strong>Primera aparición:</strong> ${character.origin.name}</p>
                             </div>
                        </div>
                    `);
                });
            },
            error: function (error) {
                alert('Error al cargar los personajes.');
                console.error(error);
                }
    });
});