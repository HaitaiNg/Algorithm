# import the Flask class from the flask module
from flask import Flask, render_template, redirect, url_for, request

# create the application object
app = Flask(__name__)

# About page 
@app.route('/about/')
def about():
    return render_template('about.html') 

# use decorators to link the function to a url
@app.route('/')
def home():
    #Flash framework has been written in a way so that it looks for 
    #files in a folder that should be name Templates. You should
    #store all your HTML templates in the Templates folder.
    # PYTHON SCRIPT STAYS OUTSIDE OF THE TEMPLATES DIRECTORY  
    return render_template('home.html') 
    #return "Spotify User Top Tracks & Artists Summary"

@app.route('/contact')
def contact ():
    return render_template('contact.html')  # render a template

# Route for handling the login page logic
@app.route('/login', methods=['GET', 'POST'])
def login():
    error = None
    if request.method == 'POST':
        if request.form['username'] != 'admin' or request.form['password'] != 'admin':
            error = 'Invalid Credentials. Please try again.'
        else:
            return redirect(url_for('home'))
    return render_template('login.html', error=error)

# start the server with the 'run()' method
if __name__ == '__main__':
    app.run(debug=True)
