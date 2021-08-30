const path = require('path')

module.exports = {
  reactStrictMode: true,
  sassOptions: {
    includePaths: [path.join(__dirname, 'styles')]
  },
  async rewrites() {
    return [
      {
        source: '/api/:path*',
        destination: `http://${process.env.APP_SERVER}:${process.env.APP_PORT}/:path*`
      },
      { 
        source: '/static/:path*',
        destination: `http://${process.env.APP_SERVER}:${process.env.APP_PORT}/:path*`
      }
    ]
  }
}
