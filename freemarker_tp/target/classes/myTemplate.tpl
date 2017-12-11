<html>
Films : <br>
<#list listeFilms as film>
<ul>
<li>${film.titre} ${film.realisateur} ${film.annee}</li>
</ul>
</#list>
</html>