/**
 * Copyright 2024 Emmanuel Bourg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.jsign;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.apache.maven.plugin.logging.Log;

/**
 * Log handler for Maven.
 *
 * @since 6.1
 */
class MavenLogHandler extends Handler {

    private final Log log;

    public MavenLogHandler(Log log) {
        this.log = log;
    }

    @Override
    public void publish(LogRecord record) {
        int level = record.getLevel().intValue();
        if (level >= Level.WARNING.intValue()) {
            log.warn(record.getMessage(), record.getThrown());
        } else if (level >= Level.INFO.intValue()) {
            log.info(record.getMessage(), record.getThrown());
        } else if (level >= Level.FINE.intValue()) {
            log.info(record.getMessage(), record.getThrown());
        } else {
            log.debug(record.getMessage(), record.getThrown());
        }
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
}
