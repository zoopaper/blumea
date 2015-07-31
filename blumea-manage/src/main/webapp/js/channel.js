$('.ui.form')
    .form({
        name: {
            identifier  : 'name',
            rules: [
                {
                    type   : 'empty',
                    prompt : 'Please enter your name'
                }
            ]
        }
    })
;