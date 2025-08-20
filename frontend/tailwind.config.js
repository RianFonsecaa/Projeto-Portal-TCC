/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: 'class',
  content: [
    "./src/**/*.{html,js,ts,jsx,tsx}",
    "./node_modules/flowbite/**/*.js"
  ],
  theme: {
    extend: {
      fontFamily: {
        russo: ['"Russo One"', 'sans-serif'],
        poppins: ["Poppins", "sans-serif"],
      }
    },
  },
  plugins: [require('flowbite/plugin')],
}

