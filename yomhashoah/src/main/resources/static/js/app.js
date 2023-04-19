function loadNewStory() {
  $.getJSON('/get_story', function(data) {
    $('#survivor-name').text(data.name);
    $('#survivor-image').attr('src', '/images/' + data.image);
    $('#survivor-story-text').text(data.story);
  });
}

$(document).ready(function() {
  loadNewStory();
  setInterval(loadNewStory, 60000); // Refresh the story every 60 seconds
});
function loadNewStory() {
  $.getJSON('/get_story', function(data) {
    $('#survivor-name').text(data.name);
    $('#survivor-image').attr('src', '/images/' + data.image);
    $('#survivor-story-text').text(data.story);
  });
}

$(document).ready(function() {
  loadNewStory();
  setInterval(loadNewStory, 60000); // Refresh the story every 60 seconds
});
