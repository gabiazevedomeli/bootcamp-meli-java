-- 1. Mostrar o título e o nome do gênero de todas as séries.

SELECT series.title, genres.name
FROM series AS series
         INNER JOIN genres AS genres
                    ON series.genre_id = genres.id;

-- 2. Mostrar o título dos episódios, o nome e o sobrenome dos atores que trabalham em cada um deles.

SELECT ep.title, ac.first_name, ac.last_name
FROM actors AS ac
         INNER JOIN actor_episode AS ae
                    ON ac.id = ae.actor_id
         INNER JOIN episodes AS ep
                    ON ep.id = ae.episode_id;

-- 3. Mostrar o título de todas as séries e o número total de temporadas que cada uma delas possui.

SELECT se.title, COUNT(sea.id) AS total_seasons
FROM series AS se
         INNER JOIN seasons AS sea
                    ON se.id = sea.serie_id
GROUP BY se.title;

-- 4. Mostrar o nome de todos os gêneros e o número total de filmes de cada um, desde que seja maior ou igual a 3.

SELECT ge.name, COUNT(mo.id) AS total_movies
FROM genres AS ge
         INNER JOIN movies AS mo
                    ON ge.id = mo.genre_id
GROUP BY ge.name
HAVING total_movies >= 3;

-- 5. Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de Star Wars e que estes não se repitam.

SELECT DISTINCT ac.first_name, ac.last_name
FROM actors AS ac
         INNER JOIN actor_movie AS am
                    ON ac.id = am.actor_id
         INNER JOIN movies AS mo
                    ON mo.id = am.movie_id
WHERE mo.title LIKE 'La Guerra de las galaxias%';