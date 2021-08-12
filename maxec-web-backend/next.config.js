module.exports = {
  reactStrictMode: true,
  
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
