#!/bin/sh

echo "BACKEND_ENDPOINT=${BACKEND_ENDPOINT}" > .env.production
yarn start