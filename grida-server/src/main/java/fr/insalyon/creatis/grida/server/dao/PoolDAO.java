/* Copyright CNRS-CREATIS
 *
 * Rafael Silva
 * rafael.silva@creatis.insa-lyon.fr
 * http://www.rafaelsilva.com
 *
 * This software is a grid-enabled data-driven workflow manager and editor.
 *
 * This software is governed by the CeCILL  license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */
package fr.insalyon.creatis.grida.server.dao;

import fr.insalyon.creatis.grida.common.bean.Operation;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rafael Silva
 */
public interface PoolDAO {

    public void addOperation(Operation operation) throws DAOException;

    public void updateOperation(Operation operation) throws DAOException;

    public void removeOperationById(String id) throws DAOException;

    public List<Operation> getOperationsByUser(String user) throws DAOException;

    public List<Operation> getDownloadPendingOperations() throws DAOException;

    public List<Operation> getUploadPendingOperations() throws DAOException;
    
    public List<Operation> getDeletePendingOperations() throws DAOException;
    
    public List<Operation> getReplicationPendingOperations() throws DAOException;

    public List<Operation> getAllOperations() throws DAOException;

    public Operation getOperationById(String id) throws DAOException;

    public void removeDeleteOperations() throws DAOException;

    public void removeOperationBySourceAndType(String source, Operation.Type type) throws DAOException;

    public void removeOperationByDestAndType(String dest, Operation.Type type) throws DAOException;

    public void removeOperationsByUser(String user) throws DAOException;
    
    public List<Operation> getOperationsByLimitDateUser(String user, int limit, Date startDate) throws DAOException;
    
    public void resetOperations() throws DAOException;
    
    public List<Operation> getOldOperations(Date date) throws DAOException;
}
